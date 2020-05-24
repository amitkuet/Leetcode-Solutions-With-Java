package com.amit.leetcode_300;

import java.util.Arrays;

public class Solution {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int len = 0;

		for (int num : nums) {
			int index = Arrays.binarySearch(dp, 0, len, num);
			if (index < 0) {
				index = -(index + 1);
			}
			dp[index] = num;
			if (len == index)
				len++;
		}
		return len;
	}

	public int lengthOfLISOn2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(dp[i], res);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // Output is 4
		System.out.println(new Solution().lengthOfLISOn2(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // Output is 4
	}

}
