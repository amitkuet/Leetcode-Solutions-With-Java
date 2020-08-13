package com.amit.leetcode_841;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] visited = new boolean[rooms.size()];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);

		while (!queue.isEmpty()) {
			int roomNo = queue.poll();
			if (!visited[roomNo]) {
				visited[roomNo] = true;
				queue.addAll(rooms.get(roomNo));
			}
		}

		for (boolean status : visited) {
			if (!status)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(Arrays.asList(1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(3));
		rooms.add(new ArrayList<>());
		System.out.println(new Solution().canVisitAllRooms(rooms));
	}

}
