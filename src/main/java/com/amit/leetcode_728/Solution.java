package com.amit.leetcode_728;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (isSelfDividingNumber(i)) {
				res.add(i);
			}
		}
		return res;
	}

	private boolean isSelfDividingNumber(int number) {
		if (number == 0) {
			return false;
		}
		int current = number;
		while (current > 1) {
			if (current % 10 == 0 || number % (current % 10) != 0) {
				return false;
			}
			current /= 10;
		}
		return true;
	}

	public static void main(String[] args) {
		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
		System.out.println(new Solution().selfDividingNumbers(1, 22));
	}

}
