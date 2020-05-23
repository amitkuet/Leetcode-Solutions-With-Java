package com.amit.leetcode_155;

class Node {
	int val;
	int minVal;
	Node next;

	public Node(int val, int minVal) {
		this.val = val;
		this.minVal = minVal;
	}
}

class MinStack {

	Node root;

	/** initialize your data structure here. */
	public MinStack() {
		root = null;
	}

	public void push(int x) {
		if (root == null) {
			Node node = new Node(x, x);
			root = node;
		} else {
			int currentMinVal = root.minVal;
			int minVal = (currentMinVal > x) ? x : currentMinVal;
			Node node = new Node(x, minVal);
			node.next = root;
			root = node;
		}
	}

	public void pop() {
		root = root.next;
	}

	public int top() {
		return root.val;
	}

	public int getMin() {
		return root.minVal;
	}

}

public class Solution {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top()); // return 0
		System.out.println(minStack.getMin()); // return -2

	}

}
