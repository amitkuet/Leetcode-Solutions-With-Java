package com.amit.leetcode_832;

public class Solution {

	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			int left = 0;
			int right = A[i].length - 1;

			while (left <= right) {
				int temp = A[i][left] ^ 1;
				A[i][left++] = A[i][right] ^ 1;
				A[i][right--] = temp;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		new Solution().flipAndInvertImage(A);

		// [[1,0,0],[0,1,0],[1,1,1]]
		for (int[] row : A) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
