package com.hussir.part001;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 *
 *     Given a string, find the length of the longest substring without repeating characters.
 */
public class Question0003 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() <= 0) return 0;

        char[] alphabets = s.toCharArray();

        ArrayList<Character> assistList = new ArrayList<>();

        int[] dp = new int[alphabets.length];
        dp[0] = 1;

        assistList.add(alphabets[0]);
        for (int i = 1; i < alphabets.length; i++) {

            if (assistList.contains(alphabets[i])) {
                int length = i - assistList.lastIndexOf(alphabets[i]);
                dp[i] = length > dp[i - 1] + 1 ? dp[i - 1] + 1 : length;
            } else {
                dp[i] = dp[i - 1] + 1;
            }

            assistList.add(i, alphabets[i]);
        }

        Arrays.sort(dp);

        return dp[dp.length - 1];
    }
}
