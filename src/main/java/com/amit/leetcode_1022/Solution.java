package com.amit.leetcode_1022;

import helper.MyTree;
import helper.TreeNode;

/**
 * 
 * Time complexity = O(N) where N is the number of nodes in the tree
 * 
 * Space complexity = O(H) where H is the height of the tree
 *
 */
public class Solution {

	int ans = 0;

	public int sumRootToLeaf(TreeNode root) {
		if (root == null) {
			return ans;
		}
		helper(root, 0);
		return ans;
	}

	private void helper(TreeNode root, int num) {
		if (root == null) {
			return;
		}
		num = (root.val == 0) ? num * 2 : (num * 2) + 1;
		if (root.left == null && root.right == null) {
			ans += num;
			return;
		}
		helper(root.left, num);
		helper(root.right, num);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 1, 0, 1, 0, 1, 0, 1 });
		System.out.println(new Solution().sumRootToLeaf(root)); // Output is 22
	}

}
