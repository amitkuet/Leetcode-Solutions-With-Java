package com.amit.leetcode_136;

public class Solution {

	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().singleNumber(new int[] { 1, 2, 3, 4, 5, 5, 4, 1, 2 })); // Output is 3
		System.out.println(new Solution().singleNumber(new int[] { 2, 2, 1 })); // Output is 1
		System.out.println(new Solution().singleNumber(new int[] { 4, 1, 2, 1, 2 })); // Output is 4
	}

}
