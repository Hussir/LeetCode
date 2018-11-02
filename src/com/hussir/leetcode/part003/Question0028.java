package com.hussir.leetcode.part003;

/**
 * Description:
 *
 *     Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Question0028 {

    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0 || needle.equals(haystack)) return 0;

        int[] next = getNextArr(needle);

        int haystackIdx = 0;
        int needleIdx = 0;

        while (haystackIdx < haystack.length() && needleIdx < needle.length()) {
            if (haystack.charAt(haystackIdx) == needle.charAt(needleIdx)) {
                haystackIdx++;
                needleIdx++;
            } else if (needleIdx == 0){
                haystackIdx++;
            } else {
                needleIdx = next[needleIdx];
            }
        }

        if (needleIdx == needle.length()) {
            return haystackIdx - needleIdx;
        }

        return -1;
    }

    private static int[] getNextArr(String needle) {

        if (needle.length() == 1) {
            return new int[]{-1};
        }

        int[] next = new int[needle.length()];

        next[0] = 0;
        next[1] = 0;

        int repeatLen = 0;
        int needleIdx = 2;
        while (needleIdx < needle.length()) {
            if (needle.charAt(repeatLen) == needle.charAt(needleIdx - 1)) {
                next[needleIdx++] = ++repeatLen;
            } else if (repeatLen > 0){
                repeatLen = next[repeatLen];
            } else {
                next[needleIdx++] = 0;
            }
        }

        return next;
    }
}
