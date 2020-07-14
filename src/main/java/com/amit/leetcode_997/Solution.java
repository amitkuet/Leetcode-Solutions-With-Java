package com.amit.leetcode_997;

public class Solution {

	public int findJudge(int N, int[][] trust) {
		int[] count = new int[N + 1];

		for (int[] t : trust) {
			count[t[0]]--;
			count[t[1]]++;
		}

		for (int i = 1; i <= N; i++) {
			if (count[i] == N - 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findJudge(2, new int[][] { { 1, 2 } })); // Output is 2
		System.out.println(new Solution().findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } })); // Output is 3
		System.out.println(new Solution().findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } })); // Output is -1
	}

}
