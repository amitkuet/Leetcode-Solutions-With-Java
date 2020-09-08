package com.amit.leetcode_983;

/**
 * 
 * Time Complexity: O(N), where N is the number of unique days in your travel
 * plan. Space Complexity: O(N).
 *
 */
public class Solution {

	int[] days, costs;
	Integer[] memo;
	int[] durations = new int[] { 1, 7, 30 };

	public int mincostTickets(int[] days, int[] costs) {
		this.days = days;
		this.costs = costs;
		memo = new Integer[days.length];

		return dp(0);
	}

	private int dp(int i) {
		System.out.println("Call function dp : " + i);
		if (i >= days.length)
			return 0;
		if (memo[i] != null)
			return memo[i];

		int min = Integer.MAX_VALUE;
		int j = i;

		for (int k = 0; k < 3; k++) {
			while (j < days.length && days[j] < days[i] + durations[k])
				j++;
			min = Math.min(min, dp(j) + costs[k]);
		}
		memo[i] = min;
		System.out.println("Call function dp : " + i + " min : " + min);
		return memo[i];
	}

	public static void main(String[] args) {
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };
		System.out.println(new Solution().mincostTickets(days, costs)); // Output is 11
	}

}
