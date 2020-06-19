package com.amit.leetcode_4;

public class Solution {

	// time - O(log(min(x, y)) space - O(1)
	static public double findMedianSortedArraysWithBinarySearch(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;

		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}
		}
		return 0.0;
	}

	// time - O(x + y) space - O(x + y)
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
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 })); // Output is 2.0
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 })); // Output is 2.5
		
		System.out.println(findMedianSortedArraysWithBinarySearch(new int[] { 1, 3 }, new int[] { 2 })); // Output is 2.0
		System.out.println(findMedianSortedArraysWithBinarySearch(new int[] { 1, 2 }, new int[] { 3, 4 })); // Output is 2.5
	}
}
