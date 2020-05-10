package com.amit.leetcode_1339;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	long totalSum;
	long maxProduct = Long.MIN_VALUE;
	final long mod = 1000000007;

	public int maxProduct(TreeNode root) {
		helper1(root);
		helper2(root);
		return (int) (maxProduct % mod);
	}

	private void helper1(TreeNode root) {
		if (root == null)
			return;
		totalSum += root.val;
		helper1(root.left);
		helper1(root.right);
	}

	private long helper2(TreeNode root) {
		if (root == null)
			return 0;
		long left = helper2(root.left);
		long right = helper2(root.right);
		maxProduct = Math.max(maxProduct, Math.max(left * (totalSum - left), right * (totalSum - right)));
		return root.val + left + right;
	}
}
