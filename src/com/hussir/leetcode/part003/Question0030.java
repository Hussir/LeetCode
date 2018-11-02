package com.hussir.leetcode.part003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:
 *
 *     You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 */
public class Question0030 {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (words.length == 0) return result;

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int strLen = s.length();
        int wordsNum = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < strLen - wordsNum * wordLen + 1; i++) {

            HashMap<String, Integer> tempMap = new HashMap<>(wordCount);

            int j = 0;
            while (j < wordsNum) {
                String subStr = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (tempMap.containsKey(subStr) && tempMap.get(subStr) > 0) {
                    tempMap.put(subStr, tempMap.get(subStr) - 1);
                    ++j;
                } else {
                    break;
                }
            }

            if (j == wordsNum) {
                result.add(i);
            }
        }

        return result;
    }
}
