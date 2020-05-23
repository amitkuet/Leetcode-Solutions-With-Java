package com.amit.leetcode_198;

public class Solution {

	public int rob(int[] nums) {
		int evenSum = 0, oddSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				evenSum = Math.max(evenSum + nums[i], oddSum);
			} else {
				oddSum = Math.max(oddSum + nums[i], evenSum);
			}
		}
		return Math.max(evenSum, oddSum);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().rob(new int[] { 1, 2, 3, 1 })); // Output is 4
		System.out.println(new Solution().rob(new int[] { 2, 7, 9, 3, 1 })); // Output is 12
	}

}
