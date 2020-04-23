package com.amit.leetcode_653;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public static boolean findTarget(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		return helper(root, k, set);
	}

	private static boolean helper(TreeNode root, int k, Set<Integer> set) {
		if (root == null) {
			return false;
		}
		if (set.contains(root.val)) {
			return true;
		} else {
			set.add(k - root.val);
		}
		boolean left = helper(root.left, k, set);
		boolean right = helper(root.right, k, set);
		return left || right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode leftChild1 = new TreeNode(3);
		TreeNode rightChild1 = new TreeNode(6);
		root.left = leftChild1;
		root.right = rightChild1;
		rightChild1.right = new TreeNode(7);
		leftChild1.left = new TreeNode(2);
		leftChild1.right = new TreeNode(4);

		System.out.println(findTarget(root, 9)); // Output should be true
	}
}
