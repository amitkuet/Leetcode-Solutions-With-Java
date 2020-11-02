package com.amit.leetcode_338;

import java.util.Arrays;

public class Solution {

	public int[] countBits(int num) {
		int[] res = new int[num + 1];

		for (int j = 0; j <= num; j++) {
			if (j % 2 == 0) {
				res[j] = res[j / 2];
			} else {
				res[j] = res[j - 1] + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] res = new Solution().countBits(5);
		System.out.println(Arrays.toString(res)); // [0, 1, 1, 2, 1, 2]
	}

}
