package com.amit.leetcode_27;

public class Solution {

	public int removeElement(int[] nums, int val) {
		int index = 0;
		for (int num : nums) {
			if (num != val) {
				nums[index++] = num;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().removeElement(new int[] { 3, 2, 2, 3 }, 3)); // Output is 2
		System.out.println(new Solution().removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2)); // Output is 5
	}

}
