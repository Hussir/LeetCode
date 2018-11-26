package com.hussir.leetcode.part004;

/**
 * Description:
 *
 *      Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 *      Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *      If the target is not found in the array, return [-1, -1].
 */
public class Question0034 {

    public int[] searchRange(int[] nums, int target) {

        int startIdx = getStartIdx(nums, 0, nums.length - 1, target);
        int endIdx = getEndIdx(nums, 0, nums.length - 1, target);

        return new int[]{startIdx, endIdx};
    }

    private int getStartIdx(int[] nums, int startIdx, int endIdx, int target) {

        if (startIdx > endIdx) return -1;

        int midIdx = startIdx + (endIdx - startIdx) / 2;

        if (nums[midIdx] == target) {
            if (midIdx == 0 || nums[midIdx - 1] != target) {
                return midIdx;
            } else {
                return getStartIdx(nums, startIdx, midIdx - 1, target);
            }
        } else if (nums[midIdx] > target) {
            return getStartIdx(nums, startIdx, midIdx - 1, target);
        } else {
            return getStartIdx(nums, midIdx + 1, endIdx, target);
        }
    }

    private int getEndIdx(int[] nums, int startIdx, int endIdx, int target) {

        if (startIdx > endIdx) return -1;

        int midIdx = startIdx + (endIdx - startIdx) / 2;

        if (nums[midIdx] == target) {
            if (midIdx == nums.length - 1 || nums[midIdx + 1] != target) {
                return midIdx;
            } else {
                return getEndIdx(nums, midIdx + 1, endIdx, target);
            }
        } else if (nums[midIdx] > target) {
            return getEndIdx(nums, startIdx, midIdx - 1, target);
        } else {
            return getEndIdx(nums, midIdx + 1, endIdx, target);
        }
    }
}