package com.hussir.leetcode.part002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 *     Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */
public class Question0018 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int nowTarget = target - nums[i] - nums[j];

                int leftIndex = j + 1;
                int rightIndex = length - 1;

                while (leftIndex < rightIndex) {

                    if (nums[leftIndex] + nums[rightIndex] == nowTarget) {

                        List<Integer> subResult = new ArrayList<>();

                        subResult.add(nums[i]);
                        subResult.add(nums[j]);
                        subResult.add(nums[leftIndex]);
                        subResult.add(nums[rightIndex]);

                        result.add(subResult);

                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) leftIndex++;
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) rightIndex--;

                        leftIndex++;
                        rightIndex--;
                    } else if (nums[leftIndex] + nums[rightIndex] > nowTarget) {
                        rightIndex--;
                    } else  {
                        leftIndex++;
                    }
                }
            }
        }

        return result;
    }
}
