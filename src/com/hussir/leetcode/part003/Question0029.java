package com.hussir.leetcode.part003;

/**
 * Description:
 *
 *     Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 */
public class Question0029 {

    public int divide(int dividend, int divisor) {

        long newDividend = (long) dividend;
        long newDivisor = (long) divisor;

        int sign = 1;

        if (newDividend < 0 && newDivisor > 0 || newDividend > 0 && newDivisor < 0) {
            sign = -1;
        }

        newDividend = Math.abs(newDividend);
        newDivisor = Math.abs(newDivisor);

        int result = 0;
        while (newDividend >= newDivisor) {

            long temp = newDivisor;
            long res = 1;

            while (newDividend >= (temp << 1)) {
                temp <<= 1;
                res <<= 1;
            }

            result += res;
            newDividend -= temp;
        }

        if(result == Integer.MIN_VALUE && sign == 1) return Integer.MAX_VALUE;

        return sign * result;
    }
}
