package com.hussir.part001;

/**
 * Description:
 *     There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 *     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 *     You may assume nums1 and nums2 cannot be both empty.
 */
public class Question0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;

        if (length % 2 == 0) {
            return (findKthSortedArrays(nums1, 0, nums2, 0, length / 2) +
                    findKthSortedArrays(nums1, 0, nums2, 0, length / 2 + 1)) / 2.0;
        } else {
            return findKthSortedArrays(nums1, 0, nums2, 0, length / 2 + 1);
        }
    }

    private double findKthSortedArrays(int[] nums1, int startIndex1, int[] nums2, int startIndex2, int k) {

        if (startIndex1 >= nums1.length) {
            return nums2[startIndex2 + k - 1];
        }

        if (startIndex2 >= nums2.length) {
            return nums1[startIndex1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[startIndex1], nums2[startIndex2]);
        }

        int halfNums1 = startIndex1 + k / 2 - 1 < nums1.length ? nums1[startIndex1 + k / 2 - 1] : Integer.MAX_VALUE;
        int halfNums2 = startIndex2 + k / 2 - 1 < nums1.length ? nums2[startIndex1 + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfNums1 > halfNums2) {
            return findKthSortedArrays(nums1, startIndex1, nums2, startIndex2 + k / 2, k - k / 2);
        } else  {
            return findKthSortedArrays(nums1, startIndex1 + k / 2, nums2, startIndex2, k - k / 2);
        }
    }
}
