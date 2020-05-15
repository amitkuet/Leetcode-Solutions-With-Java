package com.amit.leetcode_70;

public class Solution {

	public int climbStairs(int n) {
		int prev1 = 1;
		int prev2 = 1;
		for (int i = 2; i <= n; i++) {
			int sum = prev1 + prev2;
			prev1 = prev2;
			prev2 = sum;
		}
		return prev2;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(2)); // Output is 2
		System.out.println(new Solution().climbStairs(3)); // Output is 3
	}

}
