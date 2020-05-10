package com.amit.leetcode_1379;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	TreeNode result;

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		helper(cloned, target);
		return result;
	}

	private void helper(TreeNode root, TreeNode target) {
		if (root == null) {
			return;
		}
		if (root.val == target.val) {
			result = root;
			return;
		}
		if (root.left != null) {
			helper(root.left, target);
		}
		if (root.right != null) {
			helper(root.right, target);
		}
	}
}
