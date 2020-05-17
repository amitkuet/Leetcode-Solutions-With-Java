package com.amit.leetcode_881;

import java.util.Arrays;

public class Solution {

	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int left = 0;
		int right = people.length - 1;
		int res = 0;

		while (left <= right) {
			res++;
			if (people[left] + people[right] <= limit) {
				left++;
			}
			right--;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numRescueBoats(new int[] { 1, 2 }, 3)); // Output is 1
		System.out.println(new Solution().numRescueBoats(new int[] { 3, 2, 2, 1 }, 3)); // Output is 3
		System.out.println(new Solution().numRescueBoats(new int[] { 3, 5, 3, 4 }, 5)); // Output is 4
	}

}
