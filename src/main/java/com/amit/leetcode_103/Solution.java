package com.amit.leetcode_103;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<TreeNode, Integer> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		map.put(root, 1);

		while (!queue.isEmpty()) {
			TreeNode current = queue.remove();
			int level = map.get(current);
			if (res.size() < level) {
				res.add(new ArrayList<>());
			}
			if (level % 2 != 0) {
				res.get(level - 1).add(current.val);
			} else {
				res.get(level - 1).add(0, current.val);
			}

			if (current.left != null) {
				queue.add(current.left);
				map.put(current.left, level + 1);
			}
			if (current.right != null) {
				queue.add(current.right);
				map.put(current.right, level + 1);
			}

		}
		return res;
	}
}
