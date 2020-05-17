package com.amit.leetcode_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		if (strs == null || strs.length == 0) {
			return new ArrayList<>(map.values());
		}

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = new String(chars);

			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}
			map.get(sortedStr).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public List<List<String>> groupAnagramsEfficient(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		if (strs == null || strs.length == 0) {
			return new ArrayList<>(map.values());
		}

		for (String str : strs) {
			int[] chars = new int[26];
			for (char ch : str.toCharArray()) {
				chars[ch - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int c : chars) {
				sb.append(c);
			}
			String newString = sb.toString();

			if (!map.containsKey(newString)) {
				map.put(newString, new ArrayList<>());
			}
			map.get(newString).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		// Output is [[eat, tea, ate], [bat], [tan, nat]]
		System.out.println(new Solution().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(
				new Solution().groupAnagramsEfficient(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

}
