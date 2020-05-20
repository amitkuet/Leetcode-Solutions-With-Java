package com.amit.leetcode_34;

import java.util.Arrays;

public class Solution {

	public int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return res;
		}
		int first = find(nums, target, true);
		if (first == -1) {
			return res;
		}
		int last = find(nums, target, false);
		res[0] = first;
		res[1] = last;
		return res;
	}

	private int find(int[] nums, int target, boolean first) {
		int left = 0, right = nums.length - 1, res = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				res = mid;
				if (first) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int [] res1 = new Solution().searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
		System.out.println(Arrays.toString(res1)); // [3, 4]
		
		int [] res2 = new Solution().searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6);
		System.out.println(Arrays.toString(res2)); // [-1, -1]
	}

}
