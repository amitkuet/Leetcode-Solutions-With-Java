package com.amit.leetcode_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		List<int[]> list = new ArrayList<>();

		for (int[] p : people) {
			list.add(p[1], p);
		}
		int n = people.length;
		return list.toArray(new int[n][2]);
	}

	public static void main(String[] args) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] res = new Solution().reconstructQueue(people);
		// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
		for (int[] p : res) {
			System.out.println(p[0] + ", " + p[1]);
		}
	}

}
