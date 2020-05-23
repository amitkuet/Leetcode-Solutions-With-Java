package com.amit.leetcode_349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[] {};
		}
		Set<Integer> res = new HashSet<>();
		Set<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}

		for (int num : nums2) {
			if (set.contains(num)) {
				res.add(num);
			}
		}
		int index = 0;
		int[] ans = new int[res.size()];
		for (int num : res) {
			ans[index++] = num;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println(Arrays.toString(new Solution().intersection(nums1, nums2))); // Output is [2]
	}

}
