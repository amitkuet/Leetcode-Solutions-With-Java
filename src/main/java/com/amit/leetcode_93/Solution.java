package com.amit.leetcode_93;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		int n = s.length();

		for (int i = 1; i < n && i < 4; i++) {
			String first = s.substring(0, i);
			if (!isValidPart(first))
				continue;

			for (int j = 1; i + j < n && j < 4; j++) {
				String second = s.substring(i, i + j);
				if (!isValidPart(second))
					continue;

				for (int k = 1; i + j + k < n && k < 4; k++) {
					String third = s.substring(i + j, i + j + k);
					String fourth = s.substring(i + j + k);
					if (!isValidPart(third) || !isValidPart(fourth))
						continue;
					String ip = first + "." + second + "." + third + "." + fourth;
					res.add(ip);
				}
			}
		}
		return res;
	}

	private boolean isValidPart(String s) {
		int len = s.length();
		if (len > 3) {
			return false;
		}
		if (s.startsWith("0") && len > 1) {
			return false;
		}
		int val = Integer.parseInt(s);
		return val >= 0 && val <= 255;
	}

	public static void main(String[] args) {
		// Output is [255.255.11.135, 255.255.111.35]
		System.out.println(new Solution().restoreIpAddresses("25525511135"));
	}

}
