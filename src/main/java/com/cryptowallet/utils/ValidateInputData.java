package com.cryptowallet.utils;
import com.cryptowallet.entities.User;
import com.cryptowallet.validation.CharSetValidator;
import com.cryptowallet.validation.EmailValidatior;
import com.cryptowallet.validation.LengthValidator;
import lombok.extern.log4j.Log4j2;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class ValidateInputData {
    private Map<String, String> validationErrors;

    public ValidateInputData() {
        this.validationErrors = new HashMap<>();
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
            validationErrors.put("email charset error", "Email contains invalid characters");
            return false;
        }
        if (EmailValidatior.isNotValid(email)) {
            validationErrors.put("email format error", "Email must match the format.");
            return false;
        }
        return true;
    }

    public boolean isLoginValid (String login) {
        if (LengthValidator.isNotValid(3, 30, login)) {
            String errorMessage = "Login must be between 3 and 30 characters";
            validationErrors.put("login length error", errorMessage);
            log.info(String.format("login [%s] is not valid : %s", login, errorMessage));
            return false;
        } else if (CharSetValidator.isNotValid(login)) {
            String errorMessage = "Login contains invalid characters";
            validationErrors.put("login charset error", errorMessage);
            log.info(String.format("login [%s] is not valid : %s", login, errorMessage));
            return false;
        }
        return true;
    }

    public boolean isPasswordValid (String password) {
        if (LengthValidator.isNotValid(6, 30, password)) {
            String errorMessage = "Password must be between 6 and 30 characters";
            validationErrors.put("password length error", errorMessage);
            log.info(String.format("password [%s] is not valid : %s", password, errorMessage));
            return false;
        } else if (CharSetValidator.isNotValid(password)) {
            String errorMessage = "Password contains invalid characters";
            validationErrors.put("password charset error", errorMessage);
            log.info(String.format("password [%s] is not valid : %s", password, errorMessage));
            return false;
        }
        return true;
    }

    public Map<String, String> getValidationErrors () {return this.validationErrors;}

    public void putValidationErrors(String key, String text) {
        validationErrors.put(key, text);
    }
}
