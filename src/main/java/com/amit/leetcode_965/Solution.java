package com.amit.leetcode_965;

import helper.MyTree;
import helper.TreeNode;

/**
 * 
 * Time Complexity: O(N), where N is the number of nodes in the given tree.
 * 
 * Space Complexity: O(H), where H is the height of the given tree.
 *
 */
public class Solution {

	public boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left != null && root.val != root.left.val) {
			return false;
		}
		if (root.right != null && root.val != root.right.val) {
			return false;
		}
		return isUnivalTree(root.left) && isUnivalTree(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 1, 1, 1, 1, 1, null, 1 });
		System.out.println(new Solution().isUnivalTree(root)); // Output is true

		root = MyTree.generateTree(new Integer[] { 2, 2, 2, 5, 2 });
		System.out.println(new Solution().isUnivalTree(root)); // Output is false
	}

}
