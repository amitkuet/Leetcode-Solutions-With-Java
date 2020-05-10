package com.amit.leetcode_55;

public class Solution {

	public boolean canJump(int[] nums) {
		int lastGoodIndex = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastGoodIndex) {
				lastGoodIndex = i;
			}
		}
		return lastGoodIndex == 0;
	}

	public static void main(String[] args) {
		int[] nums1 = { 2, 3, 1, 1, 4 };
		System.out.println(new Solution().canJump(nums1)); // Output is true

		int[] nums2 = { 3, 2, 1, 0, 4 };
		System.out.println(new Solution().canJump(nums2)); // Output is false
	}

}
