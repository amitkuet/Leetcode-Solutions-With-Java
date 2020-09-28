package com.amit.leetcode_1019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import helper.ListNode;

public class Solution {

	public int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		ListNode curr = head;

		while (curr != null) {
			list.add(curr.val);
			curr = curr.next;
		}

		Stack<Integer> stack = new Stack<>();
		int[] res = new int[list.size()];

		for (int i = list.size() - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
				stack.pop();
			}

			int nextGreater = (stack.isEmpty()) ? 0 : stack.peek();
			res[i] = nextGreater;
			stack.push(list.get(i));
		}
		return res;
	}

}
