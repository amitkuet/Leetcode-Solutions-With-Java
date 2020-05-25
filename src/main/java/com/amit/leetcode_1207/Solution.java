package com.amit.leetcode_1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public boolean uniqueOccurrences(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int val : map.values()) {
			if (set.contains(val)) {
				return false;
			}
			set.add(val);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 })); // Output is true
		System.out.println(new Solution().uniqueOccurrences(new int[] { 1, 2 })); // Output is false
		System.out.println(new Solution().uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 })); // true
	}

}
