package com.amit.leetcode_101;

import java.util.LinkedList;
import java.util.Queue;

import helper.MyTree;
import helper.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
public class Solution {

	// Recursive solution
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
		if (leftTree == null && rightTree == null) {
			return true;
		}
		if (leftTree == null || rightTree == null) {
			return false;
		}
		if (leftTree.val != rightTree.val) {
			return false;
		}
		return isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);
	}

	// Iterative solution
	public boolean isSymmetricIterativeWay(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> leftTreeQueue = new LinkedList<>();
		Queue<TreeNode> rightTreeQueue = new LinkedList<>();

		leftTreeQueue.offer(root.left);
		rightTreeQueue.offer(root.right);

		while (!leftTreeQueue.isEmpty() && !rightTreeQueue.isEmpty()) {
			TreeNode leftTree = leftTreeQueue.poll();
			TreeNode rightTree = rightTreeQueue.poll();

			if ((leftTree == null && rightTree != null) || (leftTree != null && rightTree == null)) {
				return false;
			}
			if (leftTree != null) {
				if (leftTree.val != rightTree.val) {
					return false;
				}
				leftTreeQueue.offer(leftTree.left);
				leftTreeQueue.offer(leftTree.right);
				rightTreeQueue.offer(rightTree.right);
				rightTreeQueue.offer(rightTree.left);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Integer[] nums = { 1, 2, 2, 3, 4, 4, 3 };
		TreeNode root = MyTree.generateTree(nums, null, 0);
		System.out.println(new Solution().isSymmetric(root)); // Output is true
		System.out.println(new Solution().isSymmetricIterativeWay(root)); // Output it true

		Integer[] nums2 = { 1, 2, 2, null, 3, null, 3 };
		root = MyTree.generateTree(nums2, null, 0);
		System.out.println(new Solution().isSymmetric(root)); // Output is false
		System.out.println(new Solution().isSymmetricIterativeWay(root)); // Output is false
	}
}
