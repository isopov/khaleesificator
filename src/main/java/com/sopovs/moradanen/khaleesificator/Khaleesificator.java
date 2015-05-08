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
            case 'р':
                return 'л';
            default:
                return codepoint;
            }

        } else {
            return codepoint;
        }
    }

}
