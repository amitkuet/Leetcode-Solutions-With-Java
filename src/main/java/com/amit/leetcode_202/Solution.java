package com.amit.leetcode_202;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public boolean isHappy(int n) {
		if (n == 0)
			return false;
		Set<Integer> set = new HashSet<>();

		while (n != 1) {
			if (set.contains(n)) {
				return false;
			}
			set.add(n);
			n = findNext(n);
		}
		return true;
	}

	private int findNext(int n) {
		int sum = 0;
		while (n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isHappy(19)); // Output is true
	}

}
