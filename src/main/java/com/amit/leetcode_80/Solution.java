package com.amit.leetcode_80;

public class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 2;
		for (int right = 2; right < nums.length; right++) {
			if (nums[left - 2] != nums[right]) {
				nums[left++] = nums[right];
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		System.out.println(new Solution().removeDuplicates(nums)); // Output is 5

		int[] nums2 = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println(new Solution().removeDuplicates(nums2)); // Output is 7
	}
}
