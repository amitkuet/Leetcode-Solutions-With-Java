package com.amit.leetcode_551;

public class Solution {

	public boolean checkRecord(String s) {
		int countA = 0;
		int countL = 0;

		for (char c : s.toCharArray()) {
			if (c == 'A') {
				if (++countA > 1)
					return false;
				countL = 0;
			} else if (c == 'L') {
				if (++countL > 2)
					return false;
			} else {
				countL = 0;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().checkRecord("PPALLP")); // Output is true
		System.out.println(new Solution().checkRecord("PPALLL")); // Output is false
	}

}
