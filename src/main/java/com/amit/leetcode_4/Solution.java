package com.amit.leetcode_4;

public class Solution {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] mergeArr = new int[nums1.length + nums2.length];
		merge(nums1, nums2, mergeArr);
		int middle = mergeArr.length / 2;
		if (mergeArr.length % 2 == 0) {
			return (double) (mergeArr[middle] + mergeArr[middle - 1]) / 2.0;
		} else {
			return mergeArr[middle];
		}
	}

	private static void merge(int[] nums1, int[] nums2, int[] mergeArr) {
		int i = 0;
		int j = 0;
		int index = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				mergeArr[index++] = nums1[i];
				i++;
			} else {
				mergeArr[index++] = nums2[j];
				j++;
			}
		}

		while (i < nums1.length) {
			mergeArr[index++] = nums1[i];
			i++;
		}

		while (j < nums2.length) {
			mergeArr[index++] = nums2[j];
			j++;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2})); // Output is 2.0
		System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4})); // Output is 2.5
	}
}
