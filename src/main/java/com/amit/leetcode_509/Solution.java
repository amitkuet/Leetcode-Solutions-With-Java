package com.amit.leetcode_509;

public class Solution {

	public int fib(int N) {
		if (N < 2) {
			return N;
		}
		int prev1 = 0;
		int prev2 = 1;
		for (int i = 2; i <= N; i++) {
			int value = prev1 + prev2;
			prev1 = prev2;
			prev2 = value;
		}
		return prev2;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().fib(2)); // Output is 1
		System.out.println(new Solution().fib(3)); // Output is 2
		System.out.println(new Solution().fib(4)); // Output is 3
	}

}
