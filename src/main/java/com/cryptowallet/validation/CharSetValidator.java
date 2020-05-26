package com.cryptowallet.validation;

import com.cryptowallet.utils.CharSets;

public class CharSetValidator {
    private CharSetValidator(){}

    public static boolean isNotValid(String text) {
        boolean clear;
        for (char ch : text.toCharArray()) {
            clear = false;
            for (char availableChar : CharSets.STANDARD.getChars()) {
                if (availableChar == ch) {
                    clear = true;
                    break;
                }
            }
            if (!clear) return true;
        }
        return false;
    }
}
