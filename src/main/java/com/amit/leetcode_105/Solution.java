package com.amit.leetcode_105;

import java.util.HashMap;
import java.util.Map;

import helper.TreeNode;

public class Solution {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}

	private TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight,
			Map<Integer, Integer> map) {
		if (pLeft > pRight || iLeft > iRight) {
			return null;
		}
		int i = map.get(preorder[pLeft]);
		TreeNode curr = new TreeNode(preorder[pLeft]);
		curr.left = helper(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1, map);
		curr.right = helper(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight, map);
		return curr;
	}
}
