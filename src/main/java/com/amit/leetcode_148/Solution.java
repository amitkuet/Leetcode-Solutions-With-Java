package com.amit.leetcode_148;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			temp = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		temp.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(slow);

		return merge(left, right);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				current.next = l2;
				l2 = l2.next;
			} else {
				current.next = l1;
				l1 = l1.next;
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
		ListNode head = MyLinkedList.generateLinkedList(new int[] { 4, 2, 1, 3 });
		MyLinkedList.printLinkedList(new Solution().sortList(head));
	}

}
