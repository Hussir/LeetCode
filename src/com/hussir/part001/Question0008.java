package com.hussir.part001;

/**
 * Description:
 *
 *     Implement atoi which converts a string to an integer.
 *
 *     The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 *     Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 *     The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 *     If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 *     If no valid conversion could be performed, a zero value is returned.
 */
public class Question0008 {

    public int myAtoi(String str) {

        if (str == null || str.length() == 0) return 0;

        String tempStr = str.trim();

        boolean isNeg = false;
        long result = 0;
        for (int i = 0; i < tempStr.length(); i++) {

            char curChar = tempStr.charAt(i);
            if (i == 0 && (curChar == '-' || curChar == '+')) {
                if (curChar == '-') {
                    isNeg = true;
                }
            } else if (curChar < '0' || curChar > '9') {
                break;
            } else {
                result = result * 10 + curChar - '0';
            }

            if (result > Integer.MAX_VALUE) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return isNeg ? -(int)result : (int)result;
    }
}
