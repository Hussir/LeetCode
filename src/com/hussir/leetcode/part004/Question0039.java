package com.hussir.leetcode.part004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 *      Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 *      The same repeated number may be chosen from candidates unlimited number of times.
 *
 *      Note:
 *
 *          All numbers (including target) will be positive integers.
 *          The solution set must not contain duplicate combinations.
 */
public class Question0039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        combinationSum(candidates, target, 0, tempList, result);

        return result;
    }

    private void combinationSum(int[] candidates, int target, int startIdx, List<Integer> tempList, List<List<Integer>> result) {

        for (int i = startIdx; i < candidates.length; i++) {

            int remain = target - candidates[i];

            if (remain == 0){
                tempList.add(candidates[i]);
                result.add(tempList);
                return;
            } else if (remain > 0) {
                ArrayList<Integer> copyList = new ArrayList<>(tempList);
                copyList.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, copyList, result);
            } else {
                return;
            }
        }
    }
}