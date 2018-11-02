package com.hussir.leetcode.part002;

/**
 * Description:
 *
 *     Write a function to find the longest common prefix string amongst an array of strings.
 *
 *     If there is no common prefix, return an empty string "".
 */
public class Question0014 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            if (minLen > str.length()) {
                minLen = str.length();
            }
        }

        for (int i = 0; i < minLen; i++) {
            char preStrChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != preStrChar) {
                    return strs[j].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLen);
    }
}
