package com.amit.leetcode_88;

import java.util.Arrays;

public class Solution {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i];
				i--;
			} else {
				nums1[index--] = nums2[j];
				j--;
			}
		}

		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		new Solution().merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));  // Output is [1,2,2,3,5,6]
	}

}
