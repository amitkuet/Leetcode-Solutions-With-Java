package com.amit.leetcode_191;

public class Solution {

	public int hammingWeight(int n) {
		int result = 0;
		for (int i = 0; i < Integer.SIZE; i++) {
			result += n & 1;
			n = n >> 1;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hammingWeight(11)); // Output is 3
		System.out.println(new Solution().hammingWeight(128)); // Output is 1
		System.out.println(new Solution().hammingWeight(-3)); // Output is 31
	}

}
