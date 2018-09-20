package com.hussir.part001;

/**
 * Description:
 *     Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class Question0005 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) return s;

        char[] alphabets = s.toCharArray();

        int[] dp = new int[alphabets.length];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {

            if (i - dp[i - 1] == 0) {
                for (int j = 0; j <= i; j++) {
                    if (isPalindrome(alphabets, j, i)) {
                        dp[i] = i - j + 1;
                        break;
                    }
                }
            } else {

                if (alphabets[i] == alphabets[i - dp[i - 1] - 1]) {
                    dp[i] = dp[i - 1] + 2;
                } else {
                    for (int j = 0; j <= i; j++) {
                        if (isPalindrome(alphabets, j, i)) {
                            dp[i] = i - j + 1;
                            break;
                        }
                    }
                }
            }
        }

        String resultStr = "";
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                resultStr = s.substring(i - dp[i] + 1, i + 1);
            }
        }

        return resultStr;
    }

    private boolean isPalindrome(char[] alphabets, int left, int right) {

        while (left < right) {
            if (alphabets[left++] != alphabets[right--]) {
                return false;
            }
        }

        return true;
    }
}
