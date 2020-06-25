package com.amit.leetcode_96;

public class Solution {

	public int numTrees(int n) {
		int[] T = new int[n + 1];
		T[0] = 1;
		T[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				int left = j;
				int right = i - j - 1;
				T[i] += T[left] * T[right];
			}
		}
		return T[n];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numTrees(5)); // Output is 42
		System.out.println(new Solution().numTrees(10)); // Output is 16796
	}

}
