package com.amit.leetcode_169;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int majorityElement(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			if (map.containsKey(num) && map.get(num) + 1 > nums.length / 2) {
				return num;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().majorityElement(new int[] { 3, 2, 3 })); // Output is 3
		System.out.println(new Solution().majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 })); // Output is 2
	}

}
