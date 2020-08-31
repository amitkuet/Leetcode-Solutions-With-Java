package com.amit.leetcode_103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        if(root == null)
            return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while(!s1.isEmpty()) {
                TreeNode node = s1.pop();
                temp.add(node.val);
                if(node.left != null)
                    s2.push(node.left);
                if(node.right != null)
                    s2.push(node.right);
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
            while(!s2.isEmpty()) {
                TreeNode node = s2.pop();
                temp.add(node.val);
                if(node.right != null)
                    s1.push(node.right);
                if(node.left != null)
                    s1.push(node.left);
            }
            if(!temp.isEmpty()) res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
