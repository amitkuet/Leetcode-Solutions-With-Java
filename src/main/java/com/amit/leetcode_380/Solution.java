package com.amit.leetcode_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {

	class RandomizedSet {

		List<Integer> list;
		Map<Integer, Integer> map;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			list = new ArrayList<>();
			map = new HashMap<>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain
		 * the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			}
			list.add(val);
			map.put(val, list.size() - 1);
			return true;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified
		 * element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}
			int index = map.get(val);
			int lastElement = list.get(list.size() - 1);
			list.set(index, lastElement);
			list.remove(list.size() - 1);

			map.put(lastElement, index);
			map.remove(val);
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			int index = new Random().nextInt(list.size());
			return list.get(index);
		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
	 */

}
