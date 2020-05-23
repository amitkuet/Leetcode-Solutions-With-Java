package com.amit.leetcode_31;

import java.util.Arrays;

public class Solution {

	public void nextPermutation(int[] nums) {
		int m = nums.length - 2;
		while (m >= 0 && nums[m] >= nums[m + 1]) {
			m--;
		}
		if (m == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		int l = nums.length - 1;
		while (l > m) {
			if (nums[l] > nums[m]) {
				int temp = nums[m];
				nums[m] = nums[l];
				nums[l] = temp;
				break;
			}
			l--;
		}
		reverse(nums, m + 1, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		new Solution().nextPermutation(nums);
		System.out.println(Arrays.toString(nums)); // Output is [1, 3, 2]
	}

}
