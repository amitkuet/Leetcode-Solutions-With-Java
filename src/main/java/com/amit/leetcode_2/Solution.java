package com.amit.leetcode_2;

import helper.ListNode;
import helper.MyLinkedList;

/**
 * 
 * Time complexity : O(max(m, n)). Assume that m and n represents the length of
 * l1 and l2 respectively, the algorithm above iterates at most max(m, n) times.
 * 
 * Space complexity : O(max(m, n)). The length of the new list is at most
 * max(m,n) + 1.
 *
 */

public class Solution {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode current = result;
		
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val1 = (l1 != null) ? l1.val : 0;
			int val2 = (l2 != null) ? l2.val : 0;
			int sum = val1 + val2 + carry;
			current.next = new ListNode(sum % 10);
			carry = sum / 10;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;

			current = current.next;
		}

		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return result.next;
	}

	/*
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
	 * Output: 7 -> 0 -> 8 
	 * Explanation: 342 + 465 = 807.
	 */
	public static void main(String[] args) {
		ListNode l1 = MyLinkedList.generateLinkedList(new int[] { 2, 4, 3 });
		ListNode l2 = MyLinkedList.generateLinkedList(new int[] { 5, 6, 4 });

		ListNode result = addTwoNumbers(l1, l2);
		MyLinkedList.printLinkedList(result);
	}

}
