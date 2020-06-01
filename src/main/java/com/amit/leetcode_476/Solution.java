package com.amit.leetcode_476;

public class Solution {

	public int findComplement(int num) {
		int res = 0;
		int power = 1;

		while (num > 0) {
			res += (num % 2 ^ 1) * power;
			power = power << 1;
			num = num >> 1;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findComplement(5)); // Output is 2
	}

}
