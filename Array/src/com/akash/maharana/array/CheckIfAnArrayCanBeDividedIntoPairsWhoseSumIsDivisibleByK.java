package com.akash.maharana.array;

import java.util.HashMap;
import java.util.Map;

public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {

	public static void main(String[] args) {
		int[] arr = { 91, 74, 66, 48 };
		System.out.println(checkForDivisibility(arr, 10));
	}

	private static boolean checkForDivisibility(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int rem = arr[i] % target;
			if (!map.containsKey(rem)) {
				map.put(rem, 1);
			} else {
				map.put(rem, map.get(rem) + 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int rem = arr[i] % target;
			if (2 * rem == target) {
				if (map.get(rem) % 2 == 1) {
					return false;
				}
			} else if (rem == 0) {
				if (map.get(rem) % 2 == 1) {
					return false;
				}
			} else {
				if (map.get(rem) != map.get(target - rem)) {
					return false;
				}
			}
		}
		return true;
	}

}
