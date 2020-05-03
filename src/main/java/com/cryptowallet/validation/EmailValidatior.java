package com.cryptowallet.validation;

public class EmailValidatior {
    private EmailValidatior(){}

    public static boolean isNotValid(String text) {
        char[] textArr = text.toCharArray();
        int haveMailSymbol = 0;
        int mailSymbolPosition = 0;
        int dotLastPosition = 0;
        for (int i = 2; i < textArr.length; i++) {
            if (textArr[i] == '@') {
                haveMailSymbol++;
                mailSymbolPosition = i;
            } else if (textArr[i] == '.') {
                dotLastPosition = i;
            }
        }
        return dotLastPosition <= 1
                || haveMailSymbol != 1
                || dotLastPosition < mailSymbolPosition;
    }
}
