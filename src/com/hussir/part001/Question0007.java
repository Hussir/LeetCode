package com.hussir.part001;

/**
 * Description:
 *     Given a 32-bit signed integer, reverse digits of an integer.
 */
public class Question0007 {

    public int reverse(int x) {

        boolean isNeg = true;

        if (x >= 0) isNeg = false;

        x = Math.abs(x);

        long result = 0;

        while (x > 0) {

            if (result * 10 + x % 10 > Integer.MAX_VALUE) {
                return 0;
            }

            result = result * 10 + x % 10;

            x = x / 10;
        }

        if (isNeg) {
            return -(int)result;
        }

        return (int)result;
    }
}
