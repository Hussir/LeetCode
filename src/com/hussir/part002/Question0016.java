package com.hussir.part002;

import java.util.Arrays;

/**
 * Description:
 *
 *     Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers.
 *     You may assume that each input would have exactly one solution.
 */
public class Question0016 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {

            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {

                int sum = nums[i] + nums[leftIndex] + nums[rightIndex];

                if (sum > target) {
                    --rightIndex;
                } else if (sum < target) {
                    ++leftIndex;
                } else {
                    return target;
                }

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }

        return result;
    }
}
