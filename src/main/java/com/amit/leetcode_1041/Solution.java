package com.amit.leetcode_1041;

public class Solution {

	public boolean isRobotBounded(String instructions) {
		int direction = 0, x = 0, y = 0;

		for (char ch : instructions.toCharArray()) {
			if (ch == 'G') {
				switch (direction) {
				case 0:
					y++;
					break;
				case 1:
					x--;
					break;
				case 2:
					y--;
					break;
				case 3:
					x++;
					break;
				}
			} else if (ch == 'L') {
				direction = (direction + 1) % 4;
			} else if (ch == 'R') {
				direction = (direction == 0) ? 3 : (direction - 1);
			}
		}
		return x == 0 && y == 0 || direction != 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isRobotBounded("GGLLGG")); // Output is true
		System.out.println(new Solution().isRobotBounded("GG")); // Output is false
		System.out.println(new Solution().isRobotBounded("GL")); // Output is true
	}

}
