package com.cryptowallet.utils;
import com.cryptowallet.entities.User;
import com.cryptowallet.validation.CharSetValidator;
import com.cryptowallet.validation.LengthValidator;
import java.util.HashMap;
import java.util.Map;

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
            System.out.println(5);
            return false;
        }
        return true;
    }

    public boolean isLoginValid (String login) {
        if (LengthValidator.isNotValid(3, 30, login)) {
            validationErrors.put("login length error", "Login must be between 3 and 30 characters");
            System.out.println(3);
            return false;
        } else if (CharSetValidator.isNotValid(login)) {
            validationErrors.put("login charset error", "Login contains invalid characters");
            System.out.println(4);
            return false;
        }
        return true;
    }

    public boolean isPasswordValid (String password) {
        if (LengthValidator.isNotValid(6, 30, password)) {
            validationErrors.put("password length error", "Password must be between 6 and 30 characters");
            System.out.println(1);
            return false;
        } else if (CharSetValidator.isNotValid(password)) {
            validationErrors.put("password charset error", "Password contains invalid characters");
            System.out.println(2);
            return false;
        }
        return true;
    }

    public Map<String, String> getValidationErrors () {return this.validationErrors;}

    public void putValidationErrors(String key, String text) {
        validationErrors.put(key, text);
    }
}
