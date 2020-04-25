package com.cryptowallet.utils;

public class PasswordGenerator {
    private PasswordGenerator() {}

    public static String generate(char[] symbols, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(symbols[(int) (Math.random() * symbols.length)]);
        }
        return stringBuilder.toString();
    }

    public static String generate(int length) {
        return generate(CharSets.STANDARD.getChars(), length);
    }

}