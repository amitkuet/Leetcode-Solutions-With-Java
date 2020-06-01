package com.amit.leetcode_137;

public class Solution {

	public int singleNumber(int[] nums) {
		int res = 0;

		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int num : nums) {
				count += (num >> i) & 1;
			}

			if (count % 3 == 1) {
				res |= 1 << i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().singleNumber(new int[] { 2, 2, 3, 2 })); // Output is 3
		System.out.println(new Solution().singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 })); // Output is 99
	}

}
