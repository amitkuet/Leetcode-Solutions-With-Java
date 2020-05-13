package com.amit.leetcode_66;

import java.util.Arrays;

public class Solution {

	public int[] plusOne(int[] digits) {
		int lastIndex = digits.length - 1;

		if (digits[lastIndex] < 9) {
			digits[lastIndex]++;
			return digits;
		}
		while (lastIndex >= 0 && digits[lastIndex] == 9) {
			digits[lastIndex] = 0;
			lastIndex--;
		}
		if (lastIndex < 0) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		} else {
			digits[lastIndex]++;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] res1 = new Solution().plusOne(new int[] { 1, 2, 3 });
		System.out.println(Arrays.toString(res1)); // Output is [1, 2, 4]

		int[] res2 = new Solution().plusOne(new int[] { 4, 3, 2, 1 });
		System.out.println(Arrays.toString(res2)); // Output is [4, 3, 2, 2]

		int[] res3 = new Solution().plusOne(new int[] { 9, 9 });
		System.out.println(Arrays.toString(res3)); // Output is [1, 0, 0]
	}

}
