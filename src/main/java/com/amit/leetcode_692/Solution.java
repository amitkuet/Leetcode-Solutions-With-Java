package com.amit.leetcode_692;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			public int compare(String word1, String word2) {
				int freq1 = map.get(word1);
				int freq2 = map.get(word2);
				if (freq1 == freq2) {
					return word2.compareTo(word1);
				}
				return freq1 - freq2;
			}
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.add(entry.getKey());
			if (pq.size() > k) {
				pq.poll();
			}
		}

		List<String> res = new ArrayList<>();
		while (!pq.isEmpty()) {
			res.add(pq.poll());
		}
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		System.out.println(new Solution().topKFrequent(words, 2)); // Output is [i, love]
	}

}
