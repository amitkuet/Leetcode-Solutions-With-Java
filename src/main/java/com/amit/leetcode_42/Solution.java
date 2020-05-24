package com.amit.leetcode_42;

public class Solution {

	public int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int res = 0, left = 0, right = height.length - 1, level = 0;

		while (left < right) {
			int lower = height[height[left] < height[right] ? left++ : right--];
			level = Math.max(level, lower);
			res += level - lower;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })); // Output is 6
	}

}
