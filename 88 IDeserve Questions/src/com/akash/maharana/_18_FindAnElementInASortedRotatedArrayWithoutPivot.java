package com.akash.maharana;

public class _18_FindAnElementInASortedRotatedArrayWithoutPivot {
	
	public static void main(String[] args) {
		int[] input= {9,12,15,17,25,28,32,37,3,5,7,8};
		int key=28;
		System.out.println("Index of element "+key+" is : "+findAnElement(input,key));
	}
	
	private static int findAnElement(int[] input,int key) {
		int startIndex=0;
		int endIndex=input.length-1;
		while(startIndex<=endIndex) {
			int midIndex=(startIndex+endIndex)/2;
			if(input[midIndex]==key) {
				return midIndex;
			}
			if(input[startIndex]<=input[midIndex]) {
				if(input[startIndex]<=key && key<=input[midIndex]) {
					endIndex=midIndex-1;
				}
				else {
					startIndex=midIndex+1;
				}
			}
			else {
				if(input[midIndex]<=key && key<=input[endIndex]) {
					startIndex=midIndex+1;
				}
				else {
					endIndex=midIndex-1;
				}
			}
		}
		return -1;
	}

}
