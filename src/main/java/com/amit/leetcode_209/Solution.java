package com.amit.leetcode_209;

public class Solution {

	public int minSubArrayLen(int s, int[] nums) {
		int left = 0;
		int ans = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				ans = Math.min(ans, i + 1 - left);
				sum -= nums[left];
				left++;
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(new Solution().minSubArrayLen(7, nums)); // Output is 2
	}

}
