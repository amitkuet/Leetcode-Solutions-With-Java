package com.amit.leetcode_16;

import java.util.Arrays;

public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(closest - target)) {
					closest = sum;
				}
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}

			}
		}
		return closest;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		System.out.println(new Solution().threeSumClosest(nums, 1)); // Output is 2
	}

}
