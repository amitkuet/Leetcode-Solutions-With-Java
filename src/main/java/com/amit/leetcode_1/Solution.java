package com.amit.leetcode_1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> records = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (records.containsKey(complement)) {
				return new int[] { records.get(complement), i };
			} else {
				records.put(nums[i], i);
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int[] res = twoSum(nums, 9);
		System.out.println(res[0] + ", " + res[1]); // Output is [0,1]
	}

}
