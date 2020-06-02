package com.amit.leetcode_145;

import java.util.ArrayList;
import java.util.List;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, res);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		helper(root.left, res);
		helper(root.right, res);
		res.add(root.val);
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 1, 2, 3, 4, 5 });
		System.out.println(new Solution().postorderTraversal(root));
	}

}
