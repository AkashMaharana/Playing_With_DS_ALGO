package com.akash.maharana;

public class _24_BinaryStringWithNoConsecutiveOne {
	
	public static void main(String[] args) {
		int input=3;
		System.out.println("Total number combinations : "+numberOfCombinations(input));
	}
	
	private static int numberOfCombinations(int input) {
		int[] array1=new int[input];
		int[] array2=new int[input];
		array1[0]=1;
		array2[0]=1;
		for(int i=1;i<input;i++) {
			array1[i]=array1[i-1]+array2[i-1];
			array2[i]=array1[i-1];
		}
		return array1[input-1]+array2[input-1];
	}

}
