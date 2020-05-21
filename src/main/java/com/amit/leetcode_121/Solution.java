package com.amit.leetcode_121;

public class Solution {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int lower = prices[0];
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < lower) {
				lower = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - lower);
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // Output is 5
		System.out.println(new Solution().maxProfit(new int[] { 7, 6, 4, 3, 1 })); // Output is 0
	}

}
