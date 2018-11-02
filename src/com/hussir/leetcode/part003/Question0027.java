package com.hussir.leetcode.part003;

import java.util.Arrays;

/**
 * Description:
 *
 *     Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 */
public class Question0027 {

    public int removeElement(int[] nums, int val) {

        Arrays.sort(nums);

        int startIdx = -1;
        int repeat = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {

                repeat++;

                if (startIdx == -1) {
                    startIdx = i;
                }
            }
        }

        if (startIdx != -1) {
            for (int i = startIdx; i + repeat < nums.length; i++) {
                nums[i] = nums[i + repeat];
            }
        }

        return nums.length - repeat;
    }
}
