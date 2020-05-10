package com.amit.leetcode_445;

import java.util.Stack;

import helper.ListNode;
import helper.MyLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		ListNode head = null;
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int val1 = (stack1.isEmpty()) ? 0 : stack1.pop();
			int val2 = (stack2.isEmpty()) ? 0 : stack2.pop();
			int sum = val1 + val2 + carry;
			carry = sum / 10;
			ListNode temp = new ListNode(sum % 10);
			temp.next = head;
			head = temp;
		}
		if (carry > 0) {
			ListNode temp = new ListNode(carry);
			temp.next = head;
			head = temp;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = MyLinkedList.generateLinkedList(new int[] { 7, 2, 4, 3 });
		ListNode l2 = MyLinkedList.generateLinkedList(new int[] { 5, 6, 4 });
		Solution s = new Solution();
		ListNode res = s.addTwoNumbers(l1, l2);
		MyLinkedList.printLinkedList(res); // Output is 7 -> 8 -> 0 -> 7
	}
}
