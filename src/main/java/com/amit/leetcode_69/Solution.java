package com.amit.leetcode_69;

public class Solution {

	public int mySqrt(int x) {
		if (x < 2) {
			return x;
		}
		long left = 1;
		long right = x;

		while (left < right) {
			long mid = left + (right - left) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				right = mid;
			} else if (mid * mid < x) {
				left = mid + 1;
			}
		}
		return (int) left - 1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().mySqrt(4)); // Output is 2
		System.out.println(new Solution().mySqrt(8)); // Output is 2
	}

}
