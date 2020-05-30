package com.amit.leetcode_219;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(map.get(nums[i]) - i) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3)); // Output is true
		System.out.println(new Solution().containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1)); // Output is true
		System.out.println(new Solution().containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2)); // Output is
																										// false
	}

}
