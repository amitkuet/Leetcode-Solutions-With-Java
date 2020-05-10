package com.amit.leetcode_235;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}

	public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		System.out.println(new Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val); // Output
																												// is 6

		System.out.println(new Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val); // Output
																												// is 2

		System.out.println(new Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val); // Output
																												// is 6

		System.out.println(new Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val); // Output
																												// is 2
	}

}
