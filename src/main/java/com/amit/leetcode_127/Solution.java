package com.amit.leetcode_127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) {
			return 0;
		}

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentWord = queue.poll();
				char[] chars = currentWord.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char originalChar = chars[j];
					for (char c = 'a'; c <= 'z'; c++) {
						chars[j] = c;
						String convertedString = new String(chars);
						if (convertedString.equals(endWord)) {
							return level + 1;
						}
						if (wordSet.contains(convertedString)) {
							queue.offer(convertedString);
							wordSet.remove(convertedString);
						}
					}
					chars[j] = originalChar;
				}
			}
			level++;
		}
		return 0;
	}

	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		System.out.println(new Solution().ladderLength(beginWord, endWord, wordList)); // Output is 5
	}

}
