package com.amit.leetcode_83;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode current = head;
		while (current != null) {
			ListNode temp = current;
			while (temp != null && current.val == temp.val) {
				temp = temp.next;
			}
			current.next = temp;
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = MyLinkedList.generateLinkedList(new int[] { 1, 1, 2 }); // Output is 1 -> 2
		MyLinkedList.printLinkedList(new Solution().deleteDuplicates(head));

		head = MyLinkedList.generateLinkedList(new int[] { 1, 1, 2, 2, 3 });
		MyLinkedList.printLinkedList(new Solution().deleteDuplicates(head)); // Output is 1 -> 2 -> 3
	}

}
