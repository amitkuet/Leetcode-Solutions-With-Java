package com.amit.leetcode_412;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int num = 1; num <= n; num++) {
			if ((num % 5 == 0) && (num % 3 == 0)) {
				res.add("FizzBuzz");
			} else if (num % 5 == 0) {
				res.add("Buzz");
			} else if (num % 3 == 0) {
				res.add("Fizz");
			} else {
				res.add(String.valueOf(num));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().fizzBuzz(5)); // Output is [1, 2, Fizz, 4, Buzz]
	}

}
