package com.amit.leetcode_419;

public class Solution {

	public int countBattleships(char[][] board) {
		int numOfBattleShips = 0;
		if (board == null || board.length == 0 || board[0].length == 0) {
			return numOfBattleShips;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.')
					continue;
				if (i > 0 && board[i - 1][j] == 'X')
					continue;
				if (j > 0 && board[i][j - 1] == 'X')
					continue;
				numOfBattleShips++;
			}
		}
		return numOfBattleShips;
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		System.out.println(new Solution().countBattleships(board)); // Output is 2
	}

}
