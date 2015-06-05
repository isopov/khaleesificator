package com.sopovs.moradanen.khaleesificator;

public class Khaleesificator {

    public static String khaleesificate(String input) {
        return input.codePoints().map(Khaleesificator::khaleesificateCodePOint)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int khaleesificateCodePOint(int codepoint) {
        if (Character.isLetter(codepoint)) {
            switch ((char) codepoint) {
            case 'а':
                return 'я';
            case 'А':
                return 'Я';
            case 'р':
                return 'л';
            case 'Р':
                return 'Л';
            case 'в':
                return 'ф';
            case 'В':
                return 'Ф';
            case 'з':
                return 'с';
            case 'З':
                return 'С';
            case 'т':
                return 'д';
            case 'Т':
                return 'Д';
            case 'ж':
                return 'x';
            case 'Ж':
                return 'х';
            case 'п':
                return 'б';
            case 'П':
                return 'Б';
            default:
                return codepoint;
            }
        } else {
            return codepoint;
        }
    }
}
