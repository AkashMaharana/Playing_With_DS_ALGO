package com.akash.maharana;

public class _8_MajorityElementOfAnArray {

	public static void main(String[] args) {
		int[] input = { 4, 7, 4, 4, 7, 4, 4, 9, 4, 3 };
		System.out.println("Majority Element : " + findMajorityElement(input));
	}

	private static int findMajorityElement(int[] input) {
		int count = 0;
		int recentMajor = -1;
		for (int i = 0; i < input.length; i++) {
			if (count == 0) {
				count++;
				recentMajor = input[i];
			} else {
				if (recentMajor == input[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		if (count == 0) {
			return -1;
		}
		count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == recentMajor) {
				count++;
			}
		}
		return count > input.length / 2 ? recentMajor : -1;
	}

}
