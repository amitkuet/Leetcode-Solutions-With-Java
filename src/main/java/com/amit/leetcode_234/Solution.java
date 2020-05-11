package com.amit.leetcode_234;

import java.util.Stack;

import helper.ListNode;
import helper.MyLinkedList;

public class Solution {

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		slow = reversed(slow);
		fast = head;

		while (slow != null) {
			if (slow.val != fast.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}

	private ListNode reversed(ListNode head) {
		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public boolean isPalindromeWithStack(ListNode head) {
		if (head == null) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();

		ListNode current = head;
		while (current != null) {
			stack.push(current.val);
			current = current.next;
		}

		while (!stack.isEmpty()) {
			if (head.val != stack.pop()) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode root = MyLinkedList.generateLinkedList(new int[] { 1, 2 });
		System.out.println(new Solution().isPalindrome(root)); // false

		root = MyLinkedList.generateLinkedList(new int[] { 1, 2 });
		System.out.println(new Solution().isPalindromeWithStack(root)); // false

		root = MyLinkedList.generateLinkedList(new int[] { 1, 2, 2, 1 });
		System.out.println(new Solution().isPalindrome(root)); // true

		root = MyLinkedList.generateLinkedList(new int[] { 1, 2, 2, 1 });
		System.out.println(new Solution().isPalindromeWithStack(root)); // true
	}

}
