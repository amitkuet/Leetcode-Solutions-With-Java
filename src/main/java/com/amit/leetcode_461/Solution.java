package com.amit.leetcode_461;

public class Solution {

	public int hammingDistance2(int x, int y) {
		int count = 0;

		while (x > 0 || y > 0) {
			count += ((x & 1) != (y & 1)) ? 1 : 0;
			x = x >> 1;
			y = y >> 1;
		}
		return count;
	}

	public int hammingDistance(int x, int y) {
		int res = x ^ y;

		int count = 0;
		while (res != 0) {
			if (res % 2 == 1)
				count++;
			res = res >> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hammingDistance(1, 4)); // Output is 2
		System.out.println(new Solution().hammingDistance2(1, 4)); // Output is 2
	}

}
