package com.hussir.leetcode.part004;

/**
 * Description:
 *
 *      The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 *          1.     1
 *          2.     11
 *          3.     21
 *          4.     1211
 *          5.     111221
 *          1 is read off as "one 1" or 11.
 *          11 is read off as "two 1s" or 21.
 *          21 is read off as "one 2, then one 1" or 1211.
 *
 *      Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 *      Note: Each term of the sequence of integers will be represented as a string.
 */
public class Question0038 {

    public String countAndSay(int n) {

        String result = "1";

        if (n == 1) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            result = getNextSeq(result);
        }

        return result;
    }

    private String getNextSeq(String preSeq) {

        StringBuilder result = new StringBuilder();

        if (preSeq == null || preSeq.length() == 0) return result.toString();

        if (preSeq.length() == 1) return "1" + preSeq;

        int count = 1;
        for (int i = 1; i < preSeq.length(); i++) {

            if (preSeq.charAt(i - 1) == preSeq.charAt(i)) {
                count++;
            } else {
                result.append(count).append(preSeq.charAt(i - 1));
                count = 1;
            }

            if (i == preSeq.length() - 1) {
                result.append(count).append(preSeq.charAt(i));
            }
        }

        return result.toString();
    }
}