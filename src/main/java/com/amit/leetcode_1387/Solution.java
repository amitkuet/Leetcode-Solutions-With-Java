package com.amit.leetcode_1387;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	Map<Integer, Integer> memo = new HashMap<>();

	public int getKth(int lo, int hi, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> {
			int powerDiff = power(b) - power(a);
			if (powerDiff == 0)
				return b - a;
			return powerDiff;
		});
		for (int i = lo; i <= hi; i++) {
			maxHeap.offer(i);
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		return maxHeap.peek();
	}

	private int power(int num) {
		if (num == 1)
			return 0;
		if (memo.containsKey(num))
			return memo.get(num);

		int ans = 0;
		if ((num & 1) == 0) {
			ans = 1 + power(num / 2);
		} else {
			ans = 1 + power(num * 3 + 1);
		}
		memo.put(num, ans);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().getKth(12, 15, 2)); // Output is 13
		System.out.println(new Solution().getKth(7, 11, 4)); // Output is 7
	}

}
