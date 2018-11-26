package com.hussir.leetcode.part004;

/**
 * Description:
 *
 *      Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 *      (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 *      You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 *      You may assume no duplicate exists in the array.
 *
 *      Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class Question0033 {

    public int search(int[] nums, int target) {

        int startIdx = 0;
        int endIdx = nums.length - 1;

        while (startIdx <= endIdx) {

            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (nums[startIdx] == target) return startIdx;

            if (nums[midIdx] == target) return midIdx;

            if (nums[endIdx] == target) return endIdx;

            if (nums[midIdx] > target) endIdx--;

            if (nums[midIdx] < target) startIdx++;
        }

        return -1;
    }
}
