package com.hussir.leetcode.part004;

/**
 * Description:
 *
 *      Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 *      You may assume no duplicates in the array.
 */
public class Question0035 {

    public int searchInsert(int[] nums, int target) {

        int startIdx = 0;
        int endIdx = nums.length - 1;

        while (startIdx <= endIdx) {

            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (target == nums[midIdx]) {
                return midIdx;
            }

            if (target < nums[midIdx]) {

                if (midIdx == 0 || target > nums[midIdx - 1]) {
                    return midIdx;
                } else {
                    endIdx = midIdx - 1;
                }
            } else {
                startIdx = midIdx + 1;
            }
        }

        return target < nums[0] ? 0 : nums.length;
    }
}