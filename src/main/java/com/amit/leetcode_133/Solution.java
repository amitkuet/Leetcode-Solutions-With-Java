package com.amit.leetcode_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class Solution {

	// Time - O(N) , Space - O(N) where N is the number of nodes
	public Node cloneGraphBFS(Node node) {
		if (node == null)
			return null;
		Map<Node, Node> map = new HashMap<>();
		map.put(node, new Node(node.val));
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			Node copy = map.get(current);

			for (Node child : current.neighbors) {
				if (!map.containsKey(child)) {
					map.put(child, new Node(child.val));
					queue.offer(child);
				}
				copy.neighbors.add(map.get(child));
			}
		}
		return map.get(node);
	}

}
