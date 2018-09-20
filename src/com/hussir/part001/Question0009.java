package com.hussir.part001;

/**
 * Description:
 *     Determine whether an integer is a palindrome.
 *     An integer is a palindrome when it reads the same backward as forward.
 */
public class Question0009 {

    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        int reverseX = 0;

        int tempX = x;

        while (tempX > 0) {
            reverseX = reverseX * 10 + tempX % 10;
            tempX = tempX / 10;
        }

        return x == reverseX;
    }
}
