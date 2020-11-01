package com.amit.leetcode_617;

import helper.MyTree;
import helper.TreeNode;

/**
 * 
 * Time complexity : O(m). A total of m nodes need to be traversed. 
 * Here, m represents the minimum number of nodes from the two given trees.
 * 
 * Space complexity : O(m). The depth of the recursion tree can go upto m in the case of a skewed tree. 
 * In average case, depth will be O(logm).
 *
 *
 */
public class Solution {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	public static void main(String[] args) {
		TreeNode t1 = MyTree.generateTree(new Integer[] { 1, 3, 2, 5, null });
		TreeNode t2 = MyTree.generateTree(new Integer[] { 2, 1, 3, null, 4, null, 7 });
		TreeNode res = new Solution().mergeTrees(t1, t2);
		System.out.println(MyTree.inOrderTraversal(res));
	}

}
