package com.amit.leetcode_142;

import helper.ListNode;

// Time - O(N) where N is total number of nodes
// Space - O(1)
// The distance from head to starting point of the cycle is the same as intersect point to starting point
public class Solution {

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode intersect = intersection(head);
		if (intersect == null) {
			return null;
		}
		ListNode start = head;

		while (start != intersect) {
			start = start.next;
			intersect = intersect.next;
		}
		return start;
	}

	private ListNode intersection(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

}
