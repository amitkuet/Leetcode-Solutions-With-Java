package com.amit.leetcode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		int n = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < n - 3; i++) {
			int num1 = nums[i];
			for (int j = i + 1; j < n - 2; j++) {
				int num2 = nums[j];
				int k = j + 1;
				int l = n - 1;

				while (k < l) {
					int num3 = nums[k];
					int num4 = nums[l];
					int sum = num1 + num2 + num3 + num4;
					if (sum == target) {
						res.add(Arrays.asList(new Integer[] { num1, num2, num3, num4 }));
						while (l >= 0 && nums[l] == num4)
							l--;
						while (k < n && nums[k] == num3)
							k++;
					} else if (sum > target) {
						while (l >= 0 && nums[l] == num4)
							l--;
					} else {
						while (k < n && nums[k] == num3)
							k++;
					}
				}
				while (j + 1 < n && nums[j + 1] == nums[j])
					j++;
			}
			while (i + 1 < n && nums[i + 1] == nums[i])
				i++;
		}
		return res;
	}

	public static void main(String[] args) {
		// [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		System.out.println(new Solution().fourSum(nums, 0));
	}

}
