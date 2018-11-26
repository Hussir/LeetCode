package com.hussir.leetcode.part004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 *      Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 *      Each number in candidates may only be used once in the combination.
 *
 *      Note:
 *
 *          All numbers (including target) will be positive integers.
 *          The solution set must not contain duplicate combinations.
 */
public class Question0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        combinationSum2(candidates, target, 0, tempList, result);

        return result;
    }

    private void combinationSum2(int[] candidates, int target, int startIdx, List<Integer> tempList, List<List<Integer>> result) {

        if (target == 0) {
            result.add(tempList);
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {

            if (i > startIdx && candidates[i - 1] == candidates[i]) continue;

            List<Integer> copyList = new ArrayList<>(tempList);
            copyList.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, copyList, result);
        }
    }
}