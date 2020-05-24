package com.amit.leetcode_86;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		ListNode lessDummy = new ListNode(-1);
		ListNode less = lessDummy;
		ListNode greaterDummy = new ListNode(-1);
		ListNode greater = greaterDummy;
		ListNode current = head;

		while (current != null) {
			if (current.val < x) {
				less.next = current;
				less = less.next;
			} else {
				greater.next = current;
				greater = greater.next;
			}
			current = current.next;
		}
		greater.next = null;
		less.next = greaterDummy.next;
		return lessDummy.next;
	}

	public static void main(String[] args) {
		ListNode head = MyLinkedList.generateLinkedList(new int[] { 1, 4, 3, 2, 5, 2 });
		ListNode res = new Solution().partition(head, 3);
		MyLinkedList.printLinkedList(res); // Output is 1 -> 2 -> 2 -> 4 -> 3 -> 5
	}

}
