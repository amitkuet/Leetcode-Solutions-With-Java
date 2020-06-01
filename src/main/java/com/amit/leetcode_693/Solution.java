package com.amit.leetcode_693;

public class Solution {

	public boolean hasAlternatingBits(int n) {
		if (n == 0) {
			return false;
		}
		int prev = n % 2;
		n = n / 2;
		while (n != 0) {
			if (prev == n % 2) {
				return false;
			}
			prev = n % 2;
			n = n / 2;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hasAlternatingBits(5)); // Output is true
		System.out.println(new Solution().hasAlternatingBits(7)); // Output is false
		System.out.println(new Solution().hasAlternatingBits(11)); // Output is false
		System.out.println(new Solution().hasAlternatingBits(10)); // Output is true
	}

}
