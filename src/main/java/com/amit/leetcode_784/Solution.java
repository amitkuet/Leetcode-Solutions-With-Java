package com.amit.leetcode_784;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();
		if (S == null || S.isEmpty())
			return res;
		helper(S, 0, "", res);
		return res;
	}

	private void helper(String S, int index, String current, List<String> res) {
		if (index >= S.length()) {
			res.add(current);
			return;
		}
		char ch = S.charAt(index);
		helper(S, index + 1, current + ch, res);

		if (Character.isLetter(ch)) {
			if (ch >= 'a' && ch <= 'z') {
				helper(S, index + 1, current + Character.toUpperCase(ch), res);
			} else {
				helper(S, index + 1, current + Character.toLowerCase(ch), res);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().letterCasePermutation("a1b2")); // ["a1b2","a1B2","A1b2","A1B2"]
		System.out.println(new Solution().letterCasePermutation("3z4")); // ["3z4","3Z4"]
	}

}
