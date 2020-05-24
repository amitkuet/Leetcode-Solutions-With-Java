package com.amit.leetcode_622;

class MyCircularQueue {

	int[] queue;
	int front, rear;
	int size;
	int count;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		queue = new int[k];
		front = k - 1;
		rear = 0;
		size = k;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}
		queue[rear] = value;
		count++;
		rear = (rear + 1) % size;
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		front = (front + 1) % size;
		count--;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if (isEmpty()) {
			return -1;
		} else {
			return queue[(front + 1) % size];
		}
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if (isEmpty()) {
			return -1;
		} else {
			return queue[(rear - 1 + size) % size];
		}
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return count == 0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return count == size;
	}
}

public class Solution {

	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
		System.out.println(circularQueue.enQueue(1)); // return true
		System.out.println(circularQueue.enQueue(2)); // return true
		System.out.println(circularQueue.enQueue(3)); // return true
		System.out.println(circularQueue.enQueue(4)); // return false, the queue is full
		System.out.println(circularQueue.Rear()); // return 3
		System.out.println(circularQueue.isFull()); // return true
		System.out.println(circularQueue.deQueue()); // return true
		System.out.println(circularQueue.enQueue(4)); // return true
		System.out.println(circularQueue.Rear()); // return 4
	}

}
