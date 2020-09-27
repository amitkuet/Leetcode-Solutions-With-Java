package com.amit.leetcode_82;

import helper.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val)
					head = head.next;
			} else {
				current.next = head;
				current = current.next;
			}
			head = head.next;
		}
		current.next = null;
		return dummy.next;
	}
}
