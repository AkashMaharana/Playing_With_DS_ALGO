package com.akash.maharana;

public class _17_FindAnElementInASortedRotatedArray {
	
	public static void main(String[] args) {
		int[] input= {9,12,15,17,25,28,32,37,3,5,7,8};
		int key=37;
		int pivotIndex=findPivot(input,0,input.length-1);
		int finalIndex=0;
		if(pivotIndex==-1) {
			finalIndex=binarySearch(input, 0, input.length-1, key); 
		}
		else if(input[pivotIndex]==key) {
			finalIndex=pivotIndex;
		}
		else if(input[0]<=key) {
			finalIndex=binarySearch(input, 0, pivotIndex-1, key);
		}
		else {
			finalIndex=binarySearch(input, pivotIndex+1, input.length-1, key);
		}
		System.out.println("Index of key "+key +" is "+finalIndex);
	}
	
	private static int findPivot(int[] input,int startIndex,int endIndex) {
		if(endIndex<startIndex) {
			return -1;
		}
		if(endIndex==startIndex) {
			return startIndex;
		}
		int midIndex=startIndex+(endIndex-startIndex)/2;
		if(midIndex>startIndex && input[midIndex]<input[midIndex-1]) {
			return midIndex;
		}
		if(midIndex<endIndex && input[midIndex+1]<input[midIndex]) {
			return midIndex+1;
		}
		if(input[endIndex]>input[midIndex]) {
			return findPivot(input, startIndex, midIndex-1);
		}
		return findPivot(input, midIndex+1, endIndex);
	}
	
	private static int binarySearch(int[] input,int startIndex,int endIndex,int key) {
		if(endIndex<startIndex) {
			return -1;
		}
		int midIndex=startIndex+(endIndex-startIndex)/2;
		if(input[midIndex]==key) {
			return midIndex;
		}
		if(input[midIndex]<key) {
			return binarySearch(input, midIndex+1, endIndex, key);
		}
		return binarySearch(input, startIndex, midIndex-1, key);
	}

}
