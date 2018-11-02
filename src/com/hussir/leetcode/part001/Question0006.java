package com.hussir.leetcode.part001;

/**
 * Description:
 *
 *     The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 */
public class Question0006 {

    public String convert(String s, int numRows) {

        if (s == null || s.length() == 0 || numRows == 1) return s;

        char[] alphabets = s.toCharArray();

        char[] result = new char[alphabets.length];

        for (int i = 0, k = 0; i < numRows; i++) {
            for (int j = i; j < alphabets.length; ) {

                result[k++] = alphabets[j];

                if (i != 0 && i != numRows - 1 && j + 2 * numRows - 2 - i * 2 < alphabets.length) {
                    result[k++] = alphabets[j + 2 * numRows - 2 - i * 2];
                }

                j += 2 * numRows - 2;
            }
        }

        return new String(result);
    }
}
