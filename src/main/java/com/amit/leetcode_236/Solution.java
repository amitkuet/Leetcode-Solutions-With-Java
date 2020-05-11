package com.amit.leetcode_236;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		System.out.println(new Solution().lowestCommonAncestor(root, p, q).val); // Output is 3

		p = new TreeNode(5);
		q = new TreeNode(4);
		System.out.println(new Solution().lowestCommonAncestor(root, p, q).val); // Output is 5
	}

}
