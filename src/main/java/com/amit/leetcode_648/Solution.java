package com.amit.leetcode_648;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public String replaceWords(List<String> dictionary, String sentence) {
		TrieNode root = new TrieNode();

		for (String word : dictionary) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				TrieNode node = current.children.get(ch);
				if (node == null) {
					node = new TrieNode();
					current.children.put(ch, node);
				}
				current = node;
			}
			current.word = word;
		}

		StringBuilder sb = new StringBuilder();

		for (String word : sentence.split("\\s+")) {
			if (sb.length() > 0)
				sb.append(" ");
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				TrieNode node = current.children.get(ch);
				if (node == null)
					break;
				if (!node.word.isEmpty()) {
					word = node.word;
					break;
				}
				current = node;
			}
			sb.append(word);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		List<String> dictionary = Arrays.asList("cat", "bat", "rat");
		String sentence = "the cattle was rattled by the battery";
		System.out.println(new Solution().replaceWords(dictionary, sentence)); // the cat was rat by the bat
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	String word;

	public TrieNode() {
		this.children = new HashMap<>();
		word = "";
	}
}
