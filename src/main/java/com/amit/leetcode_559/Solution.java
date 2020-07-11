package com.amit.leetcode_559;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 
 * Time Complexity: O(N) since we must touch all nodes
 * 
 * Space Complexity: O(N) due to recursion (on a tree that may not be balanced)
 *
 */
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

public class Solution {

	int maxDepth = Integer.MIN_VALUE;

	public int maxDepthDFSSolution(Node root) {
		if (root == null) {
			return 0;
		}
		dfs(root, 1);
		return maxDepth;
	}

	private void dfs(Node root, int depth) {
		if (root == null)
			return;
		maxDepth = Math.max(maxDepth, depth);

		for (Node child : root.children) {
			dfs(child, depth + 1);
		}
	}

	public int maxDepthBFS(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				queue.addAll(curr.children);
			}
			depth++;
		}
		return depth;
	}

}
