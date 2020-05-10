package com.amit.leetcode_240;

public class Solution {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;

		int currRow = 0;
		int currCol = cols - 1;

		while (currRow < rows && currCol >= 0) {
			if (matrix[currRow][currCol] == target) {
				return true;
			} else if (matrix[currRow][currCol] > target) {
				currCol--;
			} else {
				currRow++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int [][] matrix = {
		                   {1,   4,  7, 11, 15},
		                   {2,   5,  8, 12, 19},
		                   {3,   6,  9, 16, 22},
		                   {10, 13, 14, 17, 24},
		                   {18, 21, 23, 26, 30}
		};
		System.out.println(new Solution().searchMatrix(matrix, 5)); // Output is true
		System.out.println(new Solution().searchMatrix(matrix, 20)); // Output is false
	}

}
