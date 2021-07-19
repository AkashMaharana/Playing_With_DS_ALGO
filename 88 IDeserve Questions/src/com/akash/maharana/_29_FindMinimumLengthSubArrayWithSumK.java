package com.akash.maharana;

public class _29_FindMinimumLengthSubArrayWithSumK {

	public static void main(String[] args) {
		int[] input = { 2, 3, 1, 1, -1, 6, 4, 3, 8 };
		//int[] input1 = { 2, 3, 1, 1, -1, 3, 4 };
		int target = 9;
		System.out.println(findMinimumLength(input, target));
	}

	private static int findMinimumLength(int[] arr, int target) {
		int currentSum = 0;
		int length = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				currentSum = currentSum + arr[j];
				if (currentSum == target) {
					if((j-i+1<length) || length==0) {
						length=j-i+1;
					}
					break;
				}
			}
			currentSum = 0;
		}
		return length;
	}

}
