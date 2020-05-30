package com.amit.leetcode_162;

public class Solution {

	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findPeakElement(new int[] { 1, 2, 3, 1 }));// Output is 2
		System.out.println(new Solution().findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));// Output is 1 or 5
	}

}
