package com.amit.leetcode_61;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;
		int n = 1;
		ListNode tail = head;

		while (tail.next != null) {
			tail = tail.next;
			n++;
		}
		k %= n;
		if (k == 0) {
			return head;
		}
		int noOfStepsToNewHead = n - k;
		ListNode newTail = tail;
		newTail.next = head;
		for (int i = 0; i < noOfStepsToNewHead; i++) {
			newTail = newTail.next;
		}
		ListNode newHead = newTail.next;
		newTail.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = MyLinkedList.generateLinkedList(new int[] { 1, 2, 3, 4, 5 });
		ListNode res = new Solution().rotateRight(head, 2);
		MyLinkedList.printLinkedList(res); // Output is 4 -> 5 -> 1 -> 2 -> 3
	}

}
