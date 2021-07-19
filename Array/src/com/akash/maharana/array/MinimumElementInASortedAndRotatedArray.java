package com.akash.maharana.array;

public class MinimumElementInASortedAndRotatedArray {

	public static void main(String[] args) {
		int[] input = { 5, 6, 7, 1, 2, 3, 4 };
		System.out.println("Minimum element is : " + findMinimum(input, 0, input.length - 1));
	}

	private static int findMinimum(int[] input, int low, int high) {
		if (low > high) {
			return input[0];
		}
		if (low == high) {
			return input[low];
		}
		int mid = low + (high - low) / 2;
		if (mid < high && input[mid + 1] < input[mid]) {
			return input[mid + 1];
		}
		if (mid > low && input[mid] < input[mid - 1]) {
			return input[mid];
		}
		if (input[high] > input[mid]) {
			return findMinimum(input, low, mid - 1);
		}
		return findMinimum(input, mid + 1, high);
	}

}
