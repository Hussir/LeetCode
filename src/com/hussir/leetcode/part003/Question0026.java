package com.hussir.leetcode.part003;

/**
 * Description:
 *
 *     Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 */
public class Question0026 {

    public static int removeDuplicates(int[] nums) {

        int index = nums.length > 0 ? 1 : 0;

        for (int num : nums) {
            if (num != nums[index - 1]) {
                nums[index++] = num;
            }
        }

        return index;
    }
}
