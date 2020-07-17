package com.amit.leetcode_897;

import java.util.ArrayList;
import java.util.List;

import helper.TreeNode;

/**
 * 
 * Time Complexity: O(N), where N is the number of nodes in the given tree.
 * 
 * Space Complexity: O(N), the size of the answer.
 *
 */
public class Solution {

	public TreeNode increasingBST(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<>();
		dfs(root, list);

		TreeNode ans = new TreeNode(0);
		TreeNode curr = ans;
		for (int v : list) {
			curr.right = new TreeNode(v);
			curr = curr.right;
		}
		return ans.right;
	}
	
	private void dfs(TreeNode root, List<Integer> res) {
        if(root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
