package com.amit.leetcode_912;

import java.util.Arrays;

class Solution {
	public int[] sortArray(int[] nums) {
		mergeSort(nums, nums.length);
		return nums;
	}

	private void mergeSort(int[] nums, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
		int[] rightArr = Arrays.copyOfRange(nums, mid, n);

		mergeSort(leftArr, mid);
		mergeSort(rightArr, n - mid);
		merge(nums, leftArr, rightArr, mid, n - mid);
	}

	private void merge(int[] nums, int[] leftArr, int[] rightArr, int left, int right) {
		int i = 0, j = 0, k = 0;

		while (i < left && j < right) {
			if (leftArr[i] < rightArr[j]) {
				nums[k++] = leftArr[i++];
			} else {
				nums[k++] = rightArr[j++];
			}
		}

		while (i < left) {
			nums[k++] = leftArr[i++];
		}
		while (j < right) {
			nums[k++] = rightArr[j++];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 6, 8, 5, 7, 3, 4 };
		new Solution().mergeSort(arr, arr.length);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
}
