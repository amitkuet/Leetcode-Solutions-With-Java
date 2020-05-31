package com.amit.leetcode_268;

public class Solution {

	public int missingNumber(int[] nums) {
		int len = nums.length;
		int expectedSum = (len * (len + 1)) / 2;

		int originalSum = 0;
		for (int num : nums) {
			originalSum += num;
		}
		return expectedSum - originalSum;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().missingNumber(new int[] { 3, 0, 1 })); // Output is 2
		System.out.println(new Solution().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 })); // Output is 8
	}

}
