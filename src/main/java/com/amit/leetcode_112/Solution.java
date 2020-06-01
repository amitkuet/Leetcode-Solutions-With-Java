package com.amit.leetcode_112;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		sum -= root.val;
		if (root.left == null && root.right == null && sum == 0) {
			return true;
		}
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 });
		System.out.println(new Solution().hasPathSum(root, 22)); // Output is true
	}

}
