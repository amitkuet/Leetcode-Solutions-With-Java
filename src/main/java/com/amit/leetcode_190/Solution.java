package com.amit.leetcode_190;

public class Solution {

	public int reverseBits(int n) {
		int res = 0;

		for (int i = 31; i >= 0; i--) {
			int lastDigit = n & 1;
			if (lastDigit == 1)
				res |= lastDigit << i;
			n = n >> 1;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverseBits(43261596)); // Output is 964176192
	}

}
