package com.amit.leetcode_387;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int firstUniqCharOptimalSpace(String s) {
		int[] chars = new int[26];

		for (char c : s.toCharArray()) {
			chars[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (chars[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public int firstUniqChar(String s) {
		Map<Character, Integer> charsMap = new HashMap<>();

		for (char c : s.toCharArray()) {
			charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (charsMap.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().firstUniqCharOptimalSpace("leetcode")); // Output is 0
		System.out.println(new Solution().firstUniqCharOptimalSpace("loveleetcode")); // Output is 2

		System.out.println(new Solution().firstUniqChar("leetcode")); // Output is 0
		System.out.println(new Solution().firstUniqChar("loveleetcode")); // Output is 2
	}

}
