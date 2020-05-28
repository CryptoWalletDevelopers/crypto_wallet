package com.cryptowallet.validation;

public class LengthValidator {
    private LengthValidator() {
    }

    public static boolean isNotValid(int min, int max, String text) {
        if (text == null) return true;
        int length = text.toCharArray().length;
        return length < min || length > max;
    }
}
