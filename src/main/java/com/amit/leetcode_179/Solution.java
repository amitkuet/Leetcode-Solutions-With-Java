package com.amit.leetcode_179;

import java.util.Arrays;

public class Solution {

	public String largestNumber(int[] nums) {
		String[] strArr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strArr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strArr, (a, b) -> {
			String order1 = a + b;
			String order2 = b + a;
			return order2.compareTo(order1);
		});

		if (strArr[0].equals("0")) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String num : strArr) {
			sb.append(num);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().largestNumber(new int[] { 10, 2 })); // 210
		System.out.println(new Solution().largestNumber(new int[] { 3, 30, 34, 5, 9 })); // 9534330
	}

}
