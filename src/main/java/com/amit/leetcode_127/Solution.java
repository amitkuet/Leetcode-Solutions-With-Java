package com.amit.leetcode_127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) {
			return 0;
		}

		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		int changes = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				if (word.equals(endWord)) {
					return changes;
				}

				for (int j = 0; j < word.length(); j++) {
					for (int k = 'a'; k <= 'z'; k++) {
						char[] chars = word.toCharArray();
						chars[j] = (char) k;

						String str = new String(chars);
						if (wordSet.contains(str) && !visited.contains(str)) {
							queue.add(str);
							visited.add(str);
						}
					}
				}
			}
			++changes;
		}
		return 0;
	}

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
		System.out.println(new Solution().ladderLength2(beginWord, endWord, wordList)); // Output is 5
	}

}
