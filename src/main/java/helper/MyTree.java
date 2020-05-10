package helper;

import java.util.ArrayList;
import java.util.List;

public class MyTree {
	public static TreeNode generateTree(Integer[] nums, TreeNode root, int i) {
		if (i < nums.length) {
			if (nums[i] == null) {
				return null;
			}
			TreeNode temp = new TreeNode(nums[i]);
			root = temp;

			root.left = generateTree(nums, root.left, i * 2 + 1);
			root.right = generateTree(nums, root.right, i * 2 + 2);

		}
		return root;
	}

	public static List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helperInorderTraversal(root, result);
		return result;
	}

	private static void helperInorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		helperInorderTraversal(root.left, result);
		result.add(root.val);
		helperInorderTraversal(root.right, result);
	}

	private static void helperPreorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		helperInorderTraversal(root.left, result);
		helperInorderTraversal(root.right, result);
	}

	private static void helperPostorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		helperInorderTraversal(root.left, result);
		helperInorderTraversal(root.right, result);
		result.add(root.val);
	}
}
