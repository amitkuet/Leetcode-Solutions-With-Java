package com.amit.leetcode_71;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] splittedPath = path.split("/");

		for (String p : splittedPath) {
			if (!stack.isEmpty() && p.equals("..")) {
				stack.pop();
			} else if (!p.isEmpty() && !p.equals(".") && !p.equals("..")) {
				stack.push(p);
			}
		}
		List<String> words = new ArrayList<>(stack);
		return "/" + String.join("/", words);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().simplifyPath("/home/")); // Output is /home
		System.out.println(new Solution().simplifyPath("/../")); // Output is /
		System.out.println(new Solution().simplifyPath("/home//foo/")); // Output is /home/foo
		System.out.println(new Solution().simplifyPath("/a/./b/../../c/")); // Output is /c
		System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//")); // Output is /c
		System.out.println(new Solution().simplifyPath("/a//b////c/d//././/..")); // Output is /a/b/c
	}

}
