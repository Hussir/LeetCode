package com.hussir.part002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 *     Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class Question0015 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            int target = -nums[i];

            while (leftIndex < rightIndex) {

                if (nums[leftIndex] + nums[rightIndex] == target) {

                    resultList.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));

                    while (leftIndex < rightIndex && nums[rightIndex - 1] == nums[rightIndex]) --rightIndex;
                    while (leftIndex < rightIndex && nums[leftIndex + 1] == nums[leftIndex]) ++leftIndex;

                    ++leftIndex;
                    --rightIndex;

                } else if (nums[leftIndex] + nums[rightIndex] > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }

        return resultList;
    }
}
