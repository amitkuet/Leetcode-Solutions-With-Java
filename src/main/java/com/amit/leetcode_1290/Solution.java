package com.amit.leetcode_1290;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public int getDecimalValue(ListNode head) {
		if (head == null) {
			return 0;
		}
		int len = 0;
		ListNode curr = head;
		while (curr.next != null) {
			len++;
			curr = curr.next;
		}

		curr = head;
		int ans = 0;

		while (curr != null) {
			ans += Math.pow(2, len--) * curr.val;
			curr = curr.next;
		}
		return ans;
	}

	public static void main(String[] args) {
		ListNode head = MyLinkedList.generateLinkedList(new int[] { 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 });
		System.out.println(new Solution().getDecimalValue(head)); // Output is 18880
	}

}
