package com.amit.leetcode_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		helper(nums, 0, new ArrayList<>());
		return res;
	}

	private void helper(int[] nums, int index, List<Integer> current) {
		res.add(new ArrayList<>(current));

		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i - 1] == nums[i])
				continue;
			current.add(nums[i]);
			helper(nums, i + 1, current);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
		System.out.println(new Solution().subsetsWithDup(new int[] { 1, 2, 2 }));
	}

}
