package com.amit.leetcode_1313;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static int[] decompressRLElist(int[] nums) {
		int left = 0;
		int right = 1;

		List<Integer> decompressedList = new ArrayList<>();
		while (right < nums.length) {
			int freq = nums[left];
			while (freq >= 1) {
				decompressedList.add(nums[right]);
				freq--;
			}
			left += 2;
			right += 2;
		}
		return decompressedList.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] result = decompressRLElist(nums);
		System.out.println(Arrays.toString(result)); // Output should be [2, 4, 4, 4]

		int[] nums2 = { 1, 1, 2, 3 };
		result = decompressRLElist(nums2);
		System.out.println(Arrays.toString(result)); // Output should be [1, 3, 3]
	}

}
