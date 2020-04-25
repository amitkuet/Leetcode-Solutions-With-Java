package com.amit.leetcode_2;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode result = new ListNode(-1);
		ListNode current = result;
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
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

}
