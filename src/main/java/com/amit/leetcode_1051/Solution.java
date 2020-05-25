package com.amit.leetcode_1051;

import java.util.Arrays;

public class Solution {

	public int heightChecker(int[] heights) {
		int[] sorted = heights.clone();
		Arrays.sort(sorted);

		int ans = 0;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != sorted[i])
				ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().heightChecker(new int[] { 1, 1, 4, 2, 1, 3 })); // Output is 3
		System.out.println(new Solution().heightChecker(new int[] { 5, 1, 2, 3, 4 })); // Output is 5
	}
}
