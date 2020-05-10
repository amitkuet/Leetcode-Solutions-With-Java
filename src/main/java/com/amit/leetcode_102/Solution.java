package com.amit.leetcode_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.MyTree;
import helper.TreeNode;

public class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tempList = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				tempList.add(current.val);
				if (current.left != null) {
					queue.add(current.left);
				}

				if (current.right != null) {
					queue.add(current.right);
				}
			}
			res.add(tempList);
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = MyTree.generateTree(nums);
		System.out.println(new Solution().levelOrder(root)); // Output is [[3], [9, 20], [15, 7]]
	}

}
