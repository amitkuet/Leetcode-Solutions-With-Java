package com.amit.leetcode_844;

public class Solution {

	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1, skipS = 0, skipT = 0;

		while (i >= 0 || j >= 0) {
			while (i >= 0 && (S.charAt(i) == '#' || skipS > 0)) {
				if (S.charAt(i--) == '#') {
					skipS++;
				} else {
					skipS--;
				}
			}
			while (j >= 0 && (T.charAt(j) == '#' || skipT > 0)) {
				if (T.charAt(j--) == '#') {
					skipT++;
				} else {
					skipT--;
				}
			}
			if (i < 0 || j < 0) {
				return i == j;
			}
			if (S.charAt(i--) != T.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().backspaceCompare("ab#c", "ad#c")); // Output is true
		System.out.println(new Solution().backspaceCompare("ab##", "c#d#")); // Output is true
		System.out.println(new Solution().backspaceCompare("a#c", "b")); // Output is false
	}

}
