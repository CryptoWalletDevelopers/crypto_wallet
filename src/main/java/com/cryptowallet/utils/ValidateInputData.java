package com.cryptowallet.utils;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserAuthAuthServiceFacadeImpl;
import com.cryptowallet.validation.CharSetValidator;
import com.cryptowallet.validation.EmailValidator;
import com.cryptowallet.validation.LengthValidator;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class ValidateInputData {
    private final Map<String, String> validationErrors;

    private final String EMAIL_FORMAT       = "Email must match the format";
    private final String EMAIL_EXIST        = "Email is already exist";
    private final String EMAIL_CHARSET      = "Email contains invalid characters";
    private final String LOGIN_SIZE         = "Login must be between 3 and 30 characters";
    private final String LOGIN_EXIST        = "Login is already exist";
    private final String LOGIN_CHARSET      = "Login contains invalid characters";
    private final String PASSWORD_SIZE      = "Password must be between 6 and 30 characters";
    private final String PASSWORD_CHARSET   = "Password contains invalid characters";

    public ValidateInputData() {
        this.validationErrors = new HashMap<>();
    }

    public void clearValidate() {
        validationErrors.clear();
    }

    public boolean isCorrectValidate(User user) {
        clearValidate();
        return isEmailValid(user.getEmail()) & isLoginValid(user.getLogin()) & isPasswordValid(user.getPassword());
    }

    public boolean isEmailValid(String email) {
        if (CharSetValidator.isNotValid(email)) {
            validationErrors.put("email charset error", EMAIL_CHARSET);
            log.info(String.format("login [%s] is not valid : %s", email, EMAIL_CHARSET));
            return false;
        }
        if (EmailValidator.isNotValid(email)) {
            validationErrors.put("email format error", EMAIL_FORMAT);
            log.info(String.format("login [%s] is not valid : %s", email, EMAIL_FORMAT));
            return false;
        }
        return true;
    }

    public boolean isLoginValid(String login) {
        if (LengthValidator.isNotValid(3, 30, login)) {
            validationErrors.put("login length error", LOGIN_SIZE);
            log.info(String.format("login [%s] is not valid : %s", login, LOGIN_SIZE));
            return false;
        } else if (CharSetValidator.isNotValid(login)) {
            validationErrors.put("login charset error", LOGIN_CHARSET);
            log.info(String.format("login [%s] is not valid : %s", login, LOGIN_CHARSET));
            return false;
        }
        return true;
    }

    public boolean isPasswordValid(String password) {
        if (LengthValidator.isNotValid(6, 30, password)) {
            validationErrors.put("password length error", PASSWORD_SIZE);
            log.info(String.format("password [%s] is not valid : %s", password, PASSWORD_SIZE));
            return false;
        } else if (CharSetValidator.isNotValid(password)) {
            validationErrors.put("password charset error", PASSWORD_CHARSET);
            log.info(String.format("password [%s] is not valid : %s", password, PASSWORD_CHARSET));
            return false;
        }
        return true;
    }

    public Map<String, String> getValidationErrors() {
        return this.validationErrors;
    }

    public void putValidationErrors(String key, String text) {
        validationErrors.put(key, text);
    }

    public void verifyUserCorrectness(User user, UserAuthAuthServiceFacadeImpl userAuthServiceFacadeImpl) {
        validationErrors.clear();
        if (userAuthServiceFacadeImpl.isUserExist(user.getLogin())) {
            validationErrors.put("Login is already exist", LOGIN_EXIST);
        }
        if (userAuthServiceFacadeImpl.isUserExist(user.getEmail())) {
            validationErrors.put("Email is already exist", EMAIL_EXIST);
        }
        isLoginValid(user.getLogin());
        isEmailValid(user.getEmail());
        isPasswordValid(user.getPassword());
    }

    public boolean isEmpty() {
        return validationErrors.isEmpty();
    }
}
