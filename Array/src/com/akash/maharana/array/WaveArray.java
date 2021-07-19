package com.akash.maharana.array;

public class WaveArray {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 6, 3, 2, 20, 100, 80 };
		sortAsWave(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void sortAsWave(int[] arr) {
		for(int i=0;i<arr.length;i=i+2) {
			if(i>0 && arr[i-1]>arr[i]) {
				int temp=arr[i-1];
				arr[i-1]=arr[i];
				arr[i]=temp;
			}
			if(i<arr.length-1 && arr[i]<arr[i+1]) {
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
	}

}
