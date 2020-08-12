package com.amit.leetcode_260;

/**
 * 
 * Time - O(N) where N is the length of the array
 * Space - O(1)
 */
public class Solution {

	public int[] singleNumber(int[] nums) {
		int res = 0;

		for (int num : nums) {
			res ^= num;
		}

		int mask = res & (-1 * res);

		int first = 0;
		int second = 0;
		for (int num : nums) {
			if ((mask & num) > 0) {
				first ^= num;
			} else {
				second ^= num;
			}
		}
		return new int[] { first, second };
	}

	public static void main(String[] args) {
		int[] res = new Solution().singleNumber(new int[] { 1, 2, 1, 3, 2, 5 });
		System.out.println(res[0] + ", " + res[1]); // Output is [3, 5]
	}

}
