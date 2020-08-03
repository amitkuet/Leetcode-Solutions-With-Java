package com.amit.leetcode_1161;

import java.util.LinkedList;
import java.util.Queue;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public int maxLevelSum(TreeNode root) {
		int maxLevel = Integer.MIN_VALUE;
		int maxLevelSum = Integer.MIN_VALUE;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				sum += curr.val;
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
			if (sum > maxLevelSum) {
				maxLevelSum = sum;
				maxLevel = level;
			}
			level++;
		}
		return maxLevel;
	}

	public static void main(String[] args) {
		TreeNode root = MyTree.generateTree(new Integer[] { 1, 7, 0, 7, -8, null, null });
		System.out.println(new Solution().maxLevelSum(root)); // Output is 2
	}

}
