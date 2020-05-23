package com.amit.leetcode_231;

public class Solution {

	public boolean isPowerOfTwo(int n) {
		int count = 0;
		while (n > 0) {
			count += (n & 1);
			n = n >> 1;
		}
		return count == 1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isPowerOfTwo(1)); // Output is true
		System.out.println(new Solution().isPowerOfTwo(16)); // Output is true
		System.out.println(new Solution().isPowerOfTwo(3)); // Output is false
	}

}
