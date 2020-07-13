package com.amit.leetcode_590;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Time Complexity: O(n) since we must visit all nodes.
 * 
 * Space Complexity: O(log n) on balanced tree. O(n) otherwise.
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
}

public class Solution {

	public List<Integer> postorderRecursive(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(root, res);
		return res;
	}

	private void dfs(Node root, List<Integer> res) {
		if (root == null) {
			return;
		}
		for (Node child : root.children) {
			dfs(child, res);
		}
		res.add(root.val);
	}

	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.add(root);

		while (!s1.isEmpty()) {
			Node curr = s1.pop();
			if (curr != null) {
				for (Node child : curr.children) {
					s1.add(child);
				}
				s2.add(curr);
			}
		}
		while (!s2.isEmpty()) {
			res.add(s2.pop().val);
		}
		return res;
	}

}
