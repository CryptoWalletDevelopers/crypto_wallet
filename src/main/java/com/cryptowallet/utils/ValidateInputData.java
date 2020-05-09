package com.cryptowallet.utils;
import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacade;
import com.cryptowallet.validation.CharSetValidator;
import com.cryptowallet.validation.EmailValidator;
import com.cryptowallet.validation.LengthValidator;
import lombok.extern.log4j.Log4j2;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Log4j2
public class ValidateInputData {
    private final Map<String, String> validationErrors;
    private final Properties validationMessages;

    public ValidateInputData() {
        this.validationErrors = new HashMap<>();
        this.validationMessages = new Properties();
        validationMessages.getProperty("validation_messages.properties");
    }

    public void clearValidate () {
        validationErrors.clear();
    }

    public boolean isCorrectValidate(User user) {
        clearValidate ();
        return isEmailValid(user.getEmail()) & isLoginValid(user.getLogin()) & isPasswordValid(user.getPassword());
    }

    public boolean isEmailValid (String email) {
        if (CharSetValidator.isNotValid(email)) {
            validationErrors.put("email charset error", validationMessages.getProperty("email_charset"));
            return false;
        }
        if (EmailValidator.isNotValid(email)) {
            validationErrors.put("email format error", validationMessages.getProperty("email_format"));
            return false;
        }
        return true;
    }

    public boolean isLoginValid (String login) {
        if (LengthValidator.isNotValid(3, 30, login)) {
            validationErrors.put("login length error", validationMessages.getProperty("login_size"));
            log.info(String.format("login [%s] is not valid : %s", login, validationMessages.getProperty("login_size")));
            return false;
        } else if (CharSetValidator.isNotValid(login)) {
            validationErrors.put("login charset error", validationMessages.getProperty("login_charset"));
            log.info(String.format("login [%s] is not valid : %s", login, validationMessages.getProperty("login_charset")));
            return false;
        }
        return true;
    }

    public boolean isPasswordValid (String password) {
        if (LengthValidator.isNotValid(6, 30, password)) {
            validationErrors.put("password length error", validationMessages.getProperty("password_size"));
            log.info(String.format("password [%s] is not valid : %s", password, validationMessages.getProperty("password_size")));
            return false;
        } else if (CharSetValidator.isNotValid(password)) {
            validationErrors.put("password charset error", validationMessages.getProperty("password_charset"));
            log.info(String.format("password [%s] is not valid : %s", password, validationMessages.getProperty("password_charset")));
            return false;
        }
        return true;
    }

    public Map<String, String> getValidationErrors () {return this.validationErrors;}

    public void putValidationErrors(String key, String text) {
        validationErrors.put(key, text);
    }

    public Map<String, String> validate(User user, UserServiceFacade userServiceFacade) {
        validationErrors.clear();
        if (userServiceFacade.isUserExist(user.getLogin())) {
            validationErrors.put("Login is already exist", validationMessages.getProperty("login_exist"));
        }
        if (userServiceFacade.isUserExist(user.getEmail())) {
            validationErrors.put("Email is already exist", validationMessages.getProperty("email_exist"));
        }
        isLoginValid(user.getLogin());
        isEmailValid(user.getEmail());
        isPasswordValid(user.getEmail());
        return validationErrors;
    }

    public boolean isEmpty() {
        return validationErrors.isEmpty();
    }
}
