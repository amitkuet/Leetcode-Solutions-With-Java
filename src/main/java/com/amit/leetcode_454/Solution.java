package com.amit.leetcode_454;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		int counter = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				counter += map.getOrDefault(-1 * sum, 0);
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		System.out.println(new Solution().fourSumCount(A, B, C, D)); // Output is 2
	}

}
