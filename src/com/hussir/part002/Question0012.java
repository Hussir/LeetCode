package com.hussir.part002;

/**
 * Description:
 *
 *     Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 */
public class Question0012 {

    private StringBuilder sb = new StringBuilder();

    public String intToRoman(int num) {
        return intToRoman(Integer.toString(num));
    }

    private String intToRoman(String numStr) {

        if (numStr == null || numStr.length() == 0) return numStr;

        if (numStr.charAt(0) == '0') return intToRoman(numStr.substring(1));

        int digits = numStr.length();
        int firstDigits = numStr.charAt(0) - '0';

        if (digits == 1) {
            if (firstDigits <= 3) {
                sb.append(strMulti('I', firstDigits));
            } else if (firstDigits == 4) {
                sb.append("IV");
            } else if (firstDigits < 9) {
                sb.append("V").append(strMulti('I', firstDigits - 5));
            } else {
                sb.append("IX");
            }
        }

        if (digits == 2) {
            if (firstDigits <= 3) {
                sb.append(strMulti('X', firstDigits));
            } else if (firstDigits == 4) {
                sb.append("XL");
            } else if (firstDigits < 9) {
                sb.append("L").append(strMulti('X', firstDigits - 5));
            } else {
                sb.append("XC");
            }
        }

        if (digits == 3) {
            if (firstDigits <= 3) {
                sb.append(strMulti('C', firstDigits));
            } else if (firstDigits == 4) {
                sb.append("CD");
            } else if (firstDigits < 9) {
                sb.append("D").append(strMulti('C', firstDigits - 5));
            } else {
                sb.append("CM");
            }
        }

        if (digits == 4) {
            sb.append(strMulti('M', firstDigits));
        }

        intToRoman(numStr.substring(1));

        return sb.toString();
    }

    private String strMulti(char alphabet, int num) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(alphabet);
        }

        return sb.toString();
    }
}
