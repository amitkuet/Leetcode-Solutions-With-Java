package com.amit.leetcode_122;

public class Solution {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				maxProfit += prices[i + 1] - prices[i];
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // Output is 7
		System.out.println(new Solution().maxProfit(new int[] { 1, 2, 3, 4, 5 })); // Output is 4
		System.out.println(new Solution().maxProfit(new int[] { 7, 6, 4, 3, 1 })); // Output is 0
	}

}
