package helper;

public class MyLinkedList {
	ListNode root;

	public MyLinkedList() {
		this.root = null;
	}

	public void add(int data) {
		ListNode node = new ListNode(data);
		if (root == null) {
			root = node;
			return;
		}
		ListNode current = root;

		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	public static ListNode generateLinkedList(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		ListNode root = new ListNode(nums[0]);
		ListNode current = root;
		for (int i = 1; i < nums.length; i++) {
			current.next = new ListNode(nums[i]);
			current = current.next;
		}
		return root;
	}

	public static void printLinkedList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}
