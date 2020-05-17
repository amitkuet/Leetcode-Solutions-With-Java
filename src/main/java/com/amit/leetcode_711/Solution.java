package com.amit.leetcode_711;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int numJewelsInStones(String J, String S) {
		Set<Character> jewels = new HashSet<>();

		for (char ch : J.toCharArray()) {
			jewels.add(ch);
		}

		int count = 0;
		for (char ch : S.toCharArray()) {
			if (jewels.contains(ch)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numJewelsInStones("aA", "aAAbbbb")); // Output is 3
		System.out.println(new Solution().numJewelsInStones("z", "ZZ")); // Output is 0
	}

}
