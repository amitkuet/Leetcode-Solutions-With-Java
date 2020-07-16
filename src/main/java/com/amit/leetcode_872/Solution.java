package com.amit.leetcode_872;

import java.util.ArrayList;
import java.util.List;

import helper.TreeNode;

/**
 * 
 * Time Complexity: O(T1 + T2), where T1, T2 are the lengths of the given trees.
 * 
 * Space Complexity: O(T1 + T2), the space used in storing the leaf values.
 *
 */
public class Solution {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		List<Integer> seq1 = new ArrayList<>();
		List<Integer> seq2 = new ArrayList<>();

		dfs(root1, seq1);
		dfs(root2, seq2);

		return seq1.equals(seq2);
	}

	private void dfs(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
		}
		dfs(root.left, list);
		dfs(root.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
