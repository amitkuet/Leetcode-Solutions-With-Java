package com.amit.leetcode_21;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = MyLinkedList.generateLinkedList(new int[] { 1, 2, 4 });
		ListNode l2 = MyLinkedList.generateLinkedList(new int[] { 1, 3, 4 });
		ListNode res = new Solution().mergeTwoLists(l1, l2);
		MyLinkedList.printLinkedList(res);
	}

}
