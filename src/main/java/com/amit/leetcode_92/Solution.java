package com.amit.leetcode_92;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy;
		dummy.next = head;

		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}
		ListNode curr = pre.next;

		while (m++ < n) {
			ListNode temp = curr.next;
			curr.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = MyLinkedList.generateLinkedList(new int[] { 1, 2, 3, 4, 5 });
		ListNode res = new Solution().reverseBetween(head, 2, 4);
		MyLinkedList.printLinkedList(res); // Output is 1 -> 4 -> 3 -> 2 -> 5 
	}

}
