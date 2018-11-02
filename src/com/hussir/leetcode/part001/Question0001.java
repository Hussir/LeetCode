package com.hussir.leetcode.part001;

import java.util.HashMap;

/**
 * Description:
 *
 *     an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 *     You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class Question0001 {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) return null;

        HashMap<Integer, Integer> assistMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (assistMap.containsKey(target - nums[i])) {
                return new int[]{assistMap.get(target - nums[i]), i};
            } else {
                assistMap.put(nums[i], i);
            }
        }

        return null;
    }
}
