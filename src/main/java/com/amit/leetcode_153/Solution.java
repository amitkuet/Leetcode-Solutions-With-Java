package com.amit.leetcode_153;

public class Solution {

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMin(new int[] { 3, 4, 5, 1, 2 })); // Output is 1
		System.out.println(new Solution().findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 })); // Output is 0
	}

}
