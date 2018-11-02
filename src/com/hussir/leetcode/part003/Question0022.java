package com.hussir.leetcode.part003;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 *     Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Question0022 {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        if (n <= 0) return result;

        generateParenthesis("", result, n, n);

        System.out.println(result);

        return result;
    }

    private void generateParenthesis(String subStr, List<String> result, int left, int right) {

        if (left == 0 && right == 0) {
            result.add(subStr);
            return;
        }

        if (left > 0) {
            generateParenthesis(subStr + "(", result, left - 1, right);
        }

        if (left < right) {
            generateParenthesis(subStr + ")", result, left, right - 1);
        }
    }
}
