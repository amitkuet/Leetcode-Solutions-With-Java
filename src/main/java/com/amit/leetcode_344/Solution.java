package com.amit.leetcode_344;

import java.util.Arrays;

public class Solution {

	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;

		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		char[] s = new char[] { 'h', 'e', 'l', 'l', 'o' };
		new Solution().reverseString(s);
		System.out.println(Arrays.toString(s)); // Output is [o, l, l, e, h]
	}

}
