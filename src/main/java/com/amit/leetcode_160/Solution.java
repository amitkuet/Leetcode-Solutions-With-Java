package com.amit.leetcode_160;

import java.util.HashSet;
import java.util.Set;

import helper.ListNode;

public class Solution {

	public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode a = headA;
		ListNode b = headB;

		while (a != b) {
			a = a != null ? a.next : headB;
			b = b != null ? b.next : headA;
		}
		return a;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}
}
