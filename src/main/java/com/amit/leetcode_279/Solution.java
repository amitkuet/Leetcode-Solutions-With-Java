package com.amit.leetcode_279;

public class Solution {

	public int numSquares(int n) {

		// when n=4
		// dp=[0,1,2,3,4]
		// that means for 4 we need at most 1+1+1+1= 4 perfect square numbers
		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}

		// now try to minimize the no of perfect squares neede to sum upto i
		// for making 1 , we need one perfect square which is 1
		// so dp[1]=1

		for (int i = 2; i < dp.length; i++) {
			// for each i,start traversing from j=1 upto a number whose square is
			// less than or equal to i,because we don't need any number whose square
			// is greater than i
			for (int j = 1; j * j <= i; j++) {
				// now either we can take this j or not
				// if we don't take this j,then dp[i]=dp[i]
				// if we take this j,then dp[i]= dp[i-j*j]+1
				int rest = i - (j * j);
				dp[i] = Math.min(dp[i], dp[rest] + 1);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numSquares(12)); // Output is 3
		System.out.println(new Solution().numSquares(13)); // Output is 2
	}

}
