package com.amit.leetcode_697;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Time Complexity: O(N), where N is the length of nums. Every loop is through
 * O(N) items with O(1) work inside the for-block.
 * 
 * Space Complexity: O(N), the space used by left, right, and count.
 *
 */
public class Solution {

	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> left = new HashMap<>();
		Map<Integer, Integer> right = new HashMap<>();
		Map<Integer, Integer> counts = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!left.containsKey(num)) {
				left.put(num, i);
			}
			right.put(num, i);
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		int degree = Collections.max(counts.values());
		int ans = nums.length;
		for (int key : counts.keySet()) {
			if (counts.get(key) == degree) {
				ans = Math.min(ans, right.get(key) - left.get(key) + 1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
