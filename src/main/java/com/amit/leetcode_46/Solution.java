package com.amit.leetcode_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}

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
			used[i] = false;
			permutation.remove(permutation.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new Solution().permute(nums)); // Output is [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3,
															// 1, 2], [3, 2, 1]]

	}

}
