package com.amit.leetcode_763;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> partitionLabels(String S) {
		List<Integer> res = new ArrayList<>();
		if (S == null || S.isEmpty()) {
			return res;
		}

		int[] chars = new int[26];
		for (int i = 0; i < S.length(); i++) {
			chars[S.charAt(i) - 'a'] = i;
		}

		int start = 0, end = 0;

		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, chars[S.charAt(i) - 'a']);
			if (i == end) {
				res.add(i - start + 1);
				start = i + 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij")); // Output is [9, 7, 8]
	}

}
