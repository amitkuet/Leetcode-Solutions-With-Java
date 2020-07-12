package com.amit.leetcode_589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

	public List<Integer> preorderBfs(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			res.add(curr.val);

			for (int i = curr.children.size() - 1; i >= 0; i--) {
				stack.push(curr.children.get(i));
			}
		}
		return res;
	}

	public List<Integer> preorderDfs(Node root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, res);
		return res;
	}

	private void dfs(Node root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);

		for (Node child : root.children) {
			dfs(child, res);
		}
	}

}
