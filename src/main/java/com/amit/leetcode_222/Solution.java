package com.amit.leetcode_222;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = 0;
		int rightDepth = 0;
		TreeNode pLeft = root;
		TreeNode pRight = root;

		while (pLeft != null) {
			pLeft = pLeft.left;
			leftDepth++;
		}
		while (pRight != null) {
			rightDepth++;
			pRight = pRight.right;
		}
		if (leftDepth == rightDepth) {
			return (int) Math.pow(2, leftDepth) - 1; // perfect binary tree
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 1, 2, 3, 4, 5, 6, null });
		System.out.println(new Solution().countNodes(root));
	}

}
