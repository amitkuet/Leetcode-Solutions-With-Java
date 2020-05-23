package com.amit.leetcode_328;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = odd.next;
		ListNode evenHead = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = MyLinkedList.generateLinkedList(new int[] { 1, 2, 3, 4, 5 });
		MyLinkedList.printLinkedList(new Solution().oddEvenList(head)); // Output is 1 -> 3 -> 5 -> 2 -> 4 ->  NULL
	}

}
