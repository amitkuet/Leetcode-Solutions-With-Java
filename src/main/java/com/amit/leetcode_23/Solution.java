package com.amit.leetcode_23;

import java.util.PriorityQueue;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

		for (ListNode list : lists) {
			if (list != null) {
				pq.offer(list);
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;

		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			current.next = temp;
			current = current.next;
			if (temp.next != null) {
				pq.offer(temp.next);
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		lists[0] = MyLinkedList.generateLinkedList(new int[] { 1, 4, 5 });
		lists[1] = MyLinkedList.generateLinkedList(new int[] { 1, 3, 4 });
		lists[2] = MyLinkedList.generateLinkedList(new int[] { 2, 6 });
		ListNode res = new Solution().mergeKLists(lists);
		MyLinkedList.printLinkedList(res);  // Output is 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 
	}

}
