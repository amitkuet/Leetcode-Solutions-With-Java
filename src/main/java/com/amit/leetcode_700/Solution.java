package com.amit.leetcode_700;

import java.util.Stack;

import helper.MyTree;
import helper.TreeNode;

/**
 * 
 * Runtime is O(logn) because this is a binary search.
 * 
 * Space complexity is O(H) with H being the height of the tree because of the call stack.
 *
 */
public class Solution {

	public TreeNode searchBSTIterative(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (curr != null) {
				if (curr.val == val) {
					return curr;
				} else if (curr.val < val) {
					stack.add(curr.right);
				} else {
					stack.add(curr.left);
				}
			}
		}
		return null;
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			return root;
		} else if (root.val < val) {
			return searchBST(root.right, val);
		} else {
			return searchBST(root.left, val);
		}
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 4, 2, 7, 1, 3, null, null });
		System.out.println(new Solution().searchBST(root, 2).val); // Output is 2
		System.out.println(new Solution().searchBST(root, 5)); // Output is null

		System.out.println(new Solution().searchBSTIterative(root, 2).val); // Output is 2
		System.out.println(new Solution().searchBSTIterative(root, 5)); // Output is null
	}

}
