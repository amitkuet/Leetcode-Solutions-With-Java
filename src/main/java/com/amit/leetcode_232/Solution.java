package com.amit.leetcode_232;

import java.util.Stack;

class MyQueue {

	Stack<Integer> mainStack;
	Stack<Integer> backupStack;

	/** Initialize your data structure here. */
	public MyQueue() {
		mainStack = new Stack<>();
		backupStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		mainStack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (backupStack.isEmpty()) {
			loadBackupStack();
		}
		return backupStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (backupStack.isEmpty()) {
			loadBackupStack();
		}
		return backupStack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return mainStack.isEmpty() && backupStack.isEmpty();
	}

	private void loadBackupStack() {
		while (!mainStack.isEmpty()) {
			backupStack.push(mainStack.pop());
		}
	}
}

public class Solution {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek()); // returns 1
		System.out.println(queue.pop()); // returns 1
		System.out.println(queue.empty()); // returns false
	}

}
