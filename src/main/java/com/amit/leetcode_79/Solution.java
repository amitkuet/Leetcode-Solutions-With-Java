package com.amit.leetcode_79;

public class Solution {

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (search(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, int row, int col, int index, String word) {
		if (index >= word.length()) {
			return true;
		}
		int m = board.length;
		int n = board[0].length;
		if (row < 0 || row >= m || col < 0 || col >= n || word.charAt(index) != board[row][col]) {
			return false;
		}
		char temp = board[row][col];
		board[row][col] = ' ';
		boolean res = search(board, row + 1, col, index + 1, word) || search(board, row - 1, col, index + 1, word)
				|| search(board, row, col + 1, index + 1, word) || search(board, row, col - 1, index + 1, word);
		board[row][col] = temp;
		return res;
	}

	public static void main(String[] args) {
		char [][] board = {
							{'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}
						};
		System.out.println(new Solution().exist(board, "ABCCED")); // Output is true
		System.out.println(new Solution().exist(board, "SEE")); // Output is true
		System.out.println(new Solution().exist(board, "ABCB")); // Output is false
	}

}
