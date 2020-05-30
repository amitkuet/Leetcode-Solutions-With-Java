package com.amit.leetcode_7;

public class Solution {

	// ranges from -2,147,483,648 to +2,147,483,647
	public int reverse(int x) {
		int rev = 0;

		while (x != 0) {
			int pop = x % 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && pop > 7)) {
				return 0;
			}
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			rev = rev * 10 + pop;
			x = x / 10;
		}
		return rev;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverse(123)); // Output is 321
		System.out.println(new Solution().reverse(-123)); // Output is -321
		System.out.println(new Solution().reverse(120)); // Output is 21
	}

}
