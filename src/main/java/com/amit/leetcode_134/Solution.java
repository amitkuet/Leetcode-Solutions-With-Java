package com.amit.leetcode_134;

// https://www.youtube.com/watch?v=nTKdYm_5-ZY
public class Solution {

	// Time - O(N) and Space - O(1)
	public int canCompleteCircuitOptimal(int[] gas, int[] cost) {
		int sum = 0, start = 0, diff = 0;

		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];

			if (sum < 0) {
				start = i + 1;
				diff += sum;
				sum = 0;
			}
		}
		return (sum + diff >= 0) ? start : -1;
	}

	// Time - O(N^2) and Space - O(1)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			int tank = 0;
			boolean possible = true;
			for (int j = 0; j < gas.length; j++) {
				tank += gas[(j + i) % gas.length] - cost[(j + i) % gas.length];
				if (tank < 0) {
					possible = false;
					break;
				}
			}
			if (possible) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		System.out.println(new Solution().canCompleteCircuit(gas, cost)); // Output is 3
		System.out.println(new Solution().canCompleteCircuitOptimal(gas, cost)); // Output is 3
	}

}
