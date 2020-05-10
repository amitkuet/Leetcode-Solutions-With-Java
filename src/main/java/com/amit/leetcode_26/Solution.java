package com.amit.leetcode_26;

public class Solution {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[index++] = nums[i];
			while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		System.out.println(new Solution().removeDuplicates(nums)); // Output is 2

		int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(new Solution().removeDuplicates(nums2)); // Output is 5
	}

}
