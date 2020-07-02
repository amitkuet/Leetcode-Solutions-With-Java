package com.amit.leetcode_326;

public class Solution {

	public boolean isPowerOfThreeOptimal(int n) {
		return n > 0 && Math.pow(3, 19) % n == 0;
	}

	public boolean isPowerOfThree(int n) {
		int remainder = 0;
		while (n > 1) {
			remainder = n % 3;
			if (remainder != 0) {
				return false;
			}
			n = n / 3;
		}
		return (remainder == 0 && n == 1);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isPowerOfThree(27)); // Output is true
		System.out.println(new Solution().isPowerOfThree(9)); // Output is true
		System.out.println(new Solution().isPowerOfThree(45)); // Output is false

		System.out.println(new Solution().isPowerOfThreeOptimal(27)); // Output is true
		System.out.println(new Solution().isPowerOfThreeOptimal(9)); // Output is true
		System.out.println(new Solution().isPowerOfThreeOptimal(45)); // Output is false
	}

}
