package com.amit.leetcode_404;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return sum;
		helper(root, false);
		return sum;
	}

	private void helper(TreeNode root, boolean isLeft) {
		if (root == null) {
			return;
		}
		if (isLeft && (root.left == null && root.right == null)) {
			sum += root.val;
		}
		helper(root.left, true);
		helper(root.right, false);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
		System.out.println(new Solution().sumOfLeftLeaves(root));
	}

}
