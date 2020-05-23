package com.amit.leetcode_8;

public class Solution {

	public int myAtoi(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		int sign = 1;
		long res = 0;
		int i = 0;
		int n = str.length();

		while (i < n && str.charAt(i) == ' ') {
			i++;
		}

		if (i >= n)
			return 0;

		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			sign = (str.charAt(i++) == '+') ? 1 : -1;
		}

		while (i < n && Character.isDigit(str.charAt(i))) {
			res = res * 10 + (str.charAt(i++) - '0');
			if (res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
		}
		return (int) (res * sign);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().myAtoi("42")); // Output is 42
		System.out.println(new Solution().myAtoi("   -42")); // Output is -42
		System.out.println(new Solution().myAtoi("4193 with words")); // Output is 4193
		System.out.println(new Solution().myAtoi("words and 987")); // Output is 0
	}

}
