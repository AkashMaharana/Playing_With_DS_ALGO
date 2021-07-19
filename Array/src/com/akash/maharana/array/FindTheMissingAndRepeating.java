package com.akash.maharana.array;

public class FindTheMissingAndRepeating {
	
	public static void main(String[] args) {
		int[] arr= {4, 3, 6, 2, 1, 1};
		findMissing(arr);
	}
	
	private static void findMissing(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int temp=Math.abs(arr[i]);
			if(arr[temp-1]>0) {
				arr[temp-1]=-arr[temp-1];
			}
			else {
				System.out.println("The repeating element is : "+temp);
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				System.out.println("The Missing number is : "+(i+1));
			}
		}
	}

}
