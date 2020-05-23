package com.amit.leetcode_468;

public class Solution {

	public String validIPAddress(String IP) {
		if (IP.indexOf(":") == -1) {
			int count = 0;
			for (String str : IP.split("\\.")) {
				count++;
				if (count > 4 || str.isEmpty() || (str.length() > 1 && str.charAt(0) == '0') || str.length() > 3) {
					return "Neither";
				}
				for (char c : str.toCharArray()) {
					if (!Character.isDigit(c)) {
						return "Neither";
					}
				}
				int val = Integer.parseInt(str);
				if (val < 0 || val > 255)
					return "Neither";
			}
			return (count == 4 && (IP.charAt(IP.length() - 1) != '.')) ? "IPv4" : "Neither";
		} else {
			int count = 0;
			for (String str : IP.split(":")) {
				count++;
				if (count > 8 || str.isEmpty() || str.length() > 4)
					return "Neither";
				for (char c : str.toCharArray()) {
					if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
						return "Neither";
					}
				}
			}
			return (count == 8) && (IP.charAt(IP.length() - 1) != ':') ? "IPv6" : "Neither";
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().validIPAddress("172.16.254.1")); // Output is IPv4
		System.out.println(new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // Output is IPv6
		System.out.println(new Solution().validIPAddress("256.256.256.256")); // Output is Neither
	}

}
