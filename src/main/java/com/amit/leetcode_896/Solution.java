package com.amit.leetcode_896;

public class Solution {

	public boolean isMonotonic(int[] A) {
		boolean decreasing = true;
		boolean increasing = true;

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < A[i + 1]) {
				decreasing = false;
			}
			if (A[i] > A[i + 1]) {
				increasing = false;
			}
		}
		return decreasing || increasing;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isMonotonic(new int[] { 1, 2, 2, 3 })); // Output is true
		System.out.println(new Solution().isMonotonic(new int[] { 6, 5, 4, 4 })); // Output is true
		System.out.println(new Solution().isMonotonic(new int[] { 1, 3, 2 })); // Output is false
		System.out.println(new Solution().isMonotonic(new int[] { 1, 2, 4, 5 })); // Output is true
		System.out.println(new Solution().isMonotonic(new int[] { 1, 1, 1 })); // Output is true
	}

}
