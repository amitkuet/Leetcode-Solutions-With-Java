package com.amit.leetcode_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private static final String[] MAPPINGS = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		helper(digits, 0, "", res);
		return res;
	}

	private void helper(String digits, int index, String combination, List<String> res) {
		if (index >= digits.length()) {
			res.add(combination);
			return;
		}
		String str = MAPPINGS[digits.charAt(index) - '0'];
		for (char c : str.toCharArray()) {
			helper(digits, index + 1, combination + c, res);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]
	}

}
