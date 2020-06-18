package com.amit.leetcode_213;

public class Solution {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	private int rob(int[] nums, int start, int end) {
		int incl = 0;
		int excl = 0;

		for (int i = start; i <= end; i++) {
			int temp = incl;
			incl = Math.max(incl, excl + nums[i]);
			excl = temp;
		}
		return Math.max(incl, excl);
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 2 };
		System.out.println(new Solution().rob(nums)); // Output is 3

		nums = new int[] { 1, 2, 3, 1 };
		System.out.println(new Solution().rob(nums)); // Output is 4
	}

}
