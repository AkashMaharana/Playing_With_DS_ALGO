package com.neustar;

public class PrintAllPermutation {

	public static void main(String[] args) {
		String input = "akash";
		printAllPermutation(input, 0, input.length());
	}

	private static void printAllPermutation(String string, int low, int high) {
		if (low == high) {
			System.out.println(string);
		} else {
			for (int i = low; i < high; i++) {
				string = swap(string, low, i);
				printAllPermutation(string, low + 1, high);
				string = swap(string, low, i);
			}
		}
	}

	private static String swap(String string, int i, int j) {
		char temp;
		char[] charArray = string.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
