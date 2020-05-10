package com.amit.leetcode_118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) {
			return result;
		}
		List<Integer> first = new ArrayList<>();
		first.add(1);
		result.add(first);

		if (numRows == 1) {
			return result;
		}

		for (int i = 2; i <= numRows; i++) {
			List<Integer> prev = result.get(result.size() - 1);
			List<Integer> curr = new ArrayList<>();

			for (int j = 0; j < i; j++) {
				curr.add(1);
			}
			for (int j = 1; j < i - 1; j++) {
				curr.set(j, prev.get(j - 1) + prev.get(j));
			}
			result.add(curr);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

}
