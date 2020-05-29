package com.amit.leetcode_852;

public class Solution {

	public int peakIndexInMountainArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().peakIndexInMountainArray(new int[] {0, 1, 0})); // Output is 1
		System.out.println(new Solution().peakIndexInMountainArray(new int[] {0, 2, 1, 0})); // Output is 1
	}

}
