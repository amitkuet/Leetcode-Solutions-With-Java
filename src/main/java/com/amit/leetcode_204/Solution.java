package com.amit.leetcode_204;

public class Solution {

	public int countPrimes(int n) {
		boolean[] primes = new boolean[n];

		for (int i = 0; i < n; i++) {
			primes[i] = true;
		}

		for (int i = 2; i * i < n; i++) {
			for (int j = i; j * i < n; j++) {
				primes[i * j] = false;
			}
		}

		int counter = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				counter++;
		}
		return counter;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countPrimes(10)); // Output is 4
	}

}
