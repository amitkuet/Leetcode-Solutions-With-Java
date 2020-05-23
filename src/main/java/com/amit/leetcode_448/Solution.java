package com.amit.leetcode_448;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if (nums[num - 1] > 0) {
				nums[num - 1] *= -1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })); // Output is
																											// [5, 6]
	}

}
