package com.amit.leetcode_283;

import java.util.Arrays;

public class Solution {

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				int temp = nums[i];
				nums[i++] = nums[j];
				nums[j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		new Solution().moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

}
