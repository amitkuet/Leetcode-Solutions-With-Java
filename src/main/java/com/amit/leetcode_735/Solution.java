package com.amit.leetcode_735;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < asteroids.length; i++) {
			int asteroid = asteroids[i];
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
					stack.pop();
				}
				if (stack.isEmpty() || stack.peek() < 0)
					stack.push(asteroid);
				else if (stack.peek() == -asteroid)
					stack.pop();
			}
		}

		int[] ans = new int[stack.size()];
		for (int i = ans.length - 1; i >= 0; i--) {
			ans[i] = stack.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] asteroids = { 5, 10, -5 };
		System.out.println(Arrays.toString(new Solution().asteroidCollision(asteroids))); // [5, 10]
	}

}
