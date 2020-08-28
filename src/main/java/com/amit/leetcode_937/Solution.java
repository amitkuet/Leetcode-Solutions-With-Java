package com.amit.leetcode_937;

import java.util.Arrays;

public class Solution {

	// Time - O(N * log(N)) and Space - O(log(N))
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (log1, log2) -> {
			int index1 = log1.indexOf(" ");
			String ident1 = log1.substring(0, index1);
			String mainlog1 = log1.substring(index1 + 1);

			int index2 = log2.indexOf(" ");
			String ident2 = log2.substring(0, index2);
			String mainlog2 = log2.substring(index2 + 1);

			boolean isDigit1 = Character.isDigit(mainlog1.charAt(0));
			boolean isDigit2 = Character.isDigit(mainlog2.charAt(0));

			if (!isDigit1 && !isDigit2) {
				int value = mainlog1.compareTo(mainlog2);
				if (value == 0)
					return ident1.compareTo(ident2);
				return value;
			}
			return (isDigit1) ? (isDigit2 ? 0 : 1) : -1;
		});
		return logs;
	}

	public static void main(String[] args) {
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		// ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
		System.out.println(Arrays.toString(new Solution().reorderLogFiles(logs)));
	}

}
