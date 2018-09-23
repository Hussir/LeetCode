package com.hussir.part002;

/**
 * Description:
 *
 *     Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 */
public class Question0013 {

    public int romanToInt(String s) {

        int result = 0;

        char[] digits = s.toCharArray();

        //I, V, X, L, C, D
        char[] romanValue = new char[256];
        romanValue['I'] = 1;
        romanValue['V'] = 5;
        romanValue['X'] = 10;
        romanValue['L'] = 50;
        romanValue['C'] = 100;
        romanValue['D'] = 500;
        romanValue['M'] = 1000;

        int diffIndex = 0;
        for (int i = 0; i < digits.length; i++) {

            if (i != 0 && digits[i] != digits[i - 1]) {
                diffIndex = i - 1;
            }
            if (i != 0 && romanValue[digits[i - 1]] < romanValue[digits[i]]) {
                result -= 2 * calculateInt(digits, i - 1, diffIndex, romanValue);
                result += romanValue[digits[i]];
            } else {
                result += romanValue[digits[i]];
            }
        }

        return result;
    }

    private int calculateInt(char[] digits, int index, int diffIndex, char[] romanValue) {

        int result = 0;

        for (int i = diffIndex; i <= index; i++) {
            result += romanValue[digits[i]];
        }

        return result;
    }
}
