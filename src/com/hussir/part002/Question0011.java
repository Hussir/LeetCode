package com.hussir.part002;

/**
 * Description:
 *
 *     Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 *     n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class Question0011 {

    public int maxArea(int[] heights) {

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {

                int height = Math.min(heights[i], heights[j]);
                int width = Math.abs(i - j);

                int area = height * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}
