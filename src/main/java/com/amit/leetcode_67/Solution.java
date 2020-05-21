package com.amit.leetcode_67;

public class Solution {

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int len1 = a.length() - 1;
		int len2 = b.length() - 1;

		while (len1 >= 0 || len2 >= 0) {
			int val1 = len1 >= 0 ? (a.charAt(len1) - '0') : 0;
			int val2 = len2 >= 0 ? (b.charAt(len2) - '0') : 0;

			int total = val1 + val2 + carry;
			sb.append(total % 2);
			carry = total / 2;
			len1--;
			len2--;
		}
		if (carry >= 1)
			sb.append(carry);

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().addBinary("11", "1")); // Output is 100
		System.out.println(new Solution().addBinary("1010", "1011")); // Output is 10101
	}

}
