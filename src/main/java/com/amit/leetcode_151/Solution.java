package com.amit.leetcode_151;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public String reverseWords(String s) {
		String[] words = s.trim().split("\\s+");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverseWords("the sky is blue")); // blue is sky the
		System.out.println(new Solution().reverseWords("  hello world!  ")); // world! hello
		System.out.println(new Solution().reverseWords("a good   example")); // example good a
	}

}
