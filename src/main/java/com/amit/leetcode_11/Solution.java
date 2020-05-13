package com.amit.leetcode_11;

public class Solution {

	public int maxArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int maxHeight = Integer.MIN_VALUE;
		int left = 0;
		int right = height.length - 1;

		while (left < right && right < height.length) {
			int calHeight = (right - left) * Math.min(height[left], height[right]);
			maxHeight = Math.max(maxHeight, calHeight);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxHeight;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

}
