package com.amit.leetcode_674;

class Solution {
	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int counter = 1;
		int maxSequence = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				maxSequence = Math.max(maxSequence, ++counter);
			} else {
				counter = 1;
			}
		}
		return maxSequence;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 4, 7 };
		System.out.println(new Solution().findLengthOfLCIS(nums)); // Output is 3

		int[] nums2 = { 2, 2, 2, 2, 2 };
		System.out.println(new Solution().findLengthOfLCIS(nums2)); // Output is 1
	}
}
