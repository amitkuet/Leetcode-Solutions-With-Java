package com.amit.leetcode_78;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> res) {
		res.add(new ArrayList<>(current));
		
		for(int i = index; i < nums.length; i++) {
			current.add(nums[i]);
			helper(nums, i + 1, current, res);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
		System.out.println(new Solution().subsets(new int[] { 1, 2, 3 }));
	}

}
