package com.amit.leetcode_98;

import helper.MyTree;
import helper.TreeNode;

public class Solution {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, null, null);
	}

	private boolean helper(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 2, 1, 3 });
		System.out.println(new Solution().isValidBST(root)); // Output is true

		root = MyTree.generateTree(new Integer[] { 5, 1, 4, null, null, 3, 6 });
		System.out.println(new Solution().isValidBST(root)); // Output is false
	}

}
