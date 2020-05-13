package com.amit.leetcode_100;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		TreeNode p = MyTree.generateTree(new Integer[] { 1, 2, 3 });
		TreeNode q = MyTree.generateTree(new Integer[] { 1, 2, 3 });
		System.out.println(new Solution().isSameTree(p, q)); // Output is true

		p = MyTree.generateTree(new Integer[] { 1, 2, 1 });
		q = MyTree.generateTree(new Integer[] { 1, 1, 2 });
		System.out.println(new Solution().isSameTree(p, q)); // Output is false

		p = MyTree.generateTree(new Integer[] { 1, 2 });
		q = MyTree.generateTree(new Integer[] { 1, null, 2 });
		System.out.println(new Solution().isSameTree(p, q)); // Output is false
	}

}
