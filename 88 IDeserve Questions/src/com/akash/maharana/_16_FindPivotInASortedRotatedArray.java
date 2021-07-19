package com.akash.maharana;

public class _16_FindPivotInASortedRotatedArray {
	
	public static void main(String[] args) {
		int[] input= {9,12,15,17,25,28,32,37,3,5,7,8};
		//int[] input= {1,2,3,4,5,6};
		System.out.println(findPivot(input,0,input.length-1));
	}
	
	private static int findPivot(int input[], int startIndex, int endIndex){
		if(endIndex<startIndex) {
			return input[0];
		}
		if(endIndex==startIndex) {
			return input[startIndex];
		}
		int midIndex=startIndex+(endIndex-startIndex)/2;
		if(endIndex>midIndex && input[midIndex+1]<input[midIndex]) {
			return input[midIndex+1];
		}
		if(midIndex>startIndex && input[midIndex-1]>input[midIndex]) {
			return input[midIndex];
		}
		if(input[midIndex]<input[endIndex]) {
			return findPivot(input, startIndex, midIndex-1);
		}
		return findPivot(input, midIndex+1, endIndex);
    }

}
