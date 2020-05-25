package com.amit.leetcode_1399;

public class Solution {

	public int countLargestGroup(int n) {
		int[] numbers = new int[37];

		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			int sum = findDigitSum(i + 1);
			numbers[sum]++;
			maxSum = Math.max(maxSum, numbers[sum]);
		}

		int ans = 0;
		for (int num : numbers) {
			if (maxSum == num)
				ans++;
		}
		return ans;
	}

	private int findDigitSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countLargestGroup(13)); // Output is 4
		System.out.println(new Solution().countLargestGroup(2)); // Output is 2
		System.out.println(new Solution().countLargestGroup(24)); // Output is 5
	}

}
