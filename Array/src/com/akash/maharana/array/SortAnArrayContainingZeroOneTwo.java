package com.akash.maharana.array;

public class SortAnArrayContainingZeroOneTwo {

	public static void main(String[] args) {
		int[] input = { 1, 0, 2, 1, 0, 1, 1, 0, 2, 1, 0 };
		sortArray(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}

	private static void sortArray(int[] input) {
		int firstIndex = 0;
		int secondIndex = 0;
		int thirdIndex = input.length - 1;
		while (secondIndex <= thirdIndex) {
			switch (input[secondIndex]) {
			case 0:
				int temp = input[firstIndex];
				input[firstIndex] = input[secondIndex];
				input[secondIndex] = temp;
				firstIndex++;
				secondIndex++;
				break;
			case 1:
				secondIndex++;
				break;
			case 2:
				int temp1 = input[secondIndex];
				input[secondIndex] = input[thirdIndex];
				input[thirdIndex] = temp1;
				thirdIndex--;
				break;
			}
		}
	}

}
