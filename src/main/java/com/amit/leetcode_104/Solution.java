package com.amit.leetcode_104;

import helper.MyTree;
import helper.TreeNode;

/**
 * 
 * Time Complexity: O(n) where n is the total number of nodes in the tree.
 * 
 * Space Complexity: O(H) where H is the height of the tree.
 *
 */
public class Solution {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
		System.out.println(new Solution().maxDepth(root)); // Output is 3
	}

}
