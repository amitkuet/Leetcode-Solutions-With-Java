package com.amit.leetcode_938;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	int ans = 0;

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return ans;
		helper(root, L, R);
		return ans;
	}

	private void helper(TreeNode root, int L, int R) {
		if (root == null)
			return;
		if (root.val >= L && root.val <= R) {
			ans += root.val;
		}
		if (root.val > L)
			helper(root.left, L, R);
		if (root.val < R)
			helper(root.right, L, R);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 10, 5, 15, 3, 7, null, 18 });
		System.out.println(new Solution().rangeSumBST(root, 7, 15)); // Output is 32
	}

}
