package com.amit.leetcode_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import helper.MyTree;
import helper.TreeNode;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, res);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			res.add(root.val);
			helper(root.left, res);
			helper(root.right, res);
		}
	}

	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			res.add(current.val);

			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] nums = { 1, null, 2, null, null, 3 };
		TreeNode root = MyTree.generateTree(nums);
		System.out.println(new Solution().preorderTraversalIterative(root)); // Output is [1, 2, 3]
		System.out.println(new Solution().preorderTraversal(root)); // Output is [1, 2, 3]
	}

}
