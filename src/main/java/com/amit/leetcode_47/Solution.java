package com.amit.leetcode_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		List<Integer> permutation = new ArrayList<>();
		helper(nums, permutation, used, res);
		return res;
	}

	private void helper(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> res) {
		if (nums.length == permutation.size()) {
			res.add(new ArrayList<>(permutation));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			permutation.add(nums[i]);
			used[i] = true;
			helper(nums, permutation, used, res);
			permutation.remove(permutation.size() - 1);
			used[i] = false;
			while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 2 };
		System.out.println(new Solution().permuteUnique(nums)); // Output is [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
	}
}