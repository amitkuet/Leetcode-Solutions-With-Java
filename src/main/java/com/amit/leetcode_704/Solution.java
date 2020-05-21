package com.amit.leetcode_704;

public class Solution {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().search(new int[] { -1, 0, 3, 5, 9, 12 }, 9)); // Output is 4
		System.out.println(new Solution().search(new int[] { -1, 0, 3, 5, 9, 12 }, 2)); // Output is -1
	}

}
