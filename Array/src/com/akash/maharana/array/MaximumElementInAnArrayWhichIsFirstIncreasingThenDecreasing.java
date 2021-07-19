package com.akash.maharana.array;

//Bitonic Point
public class MaximumElementInAnArrayWhichIsFirstIncreasingThenDecreasing {

	public static void main(String[] args) {
		int[] arr = {8, 10, 20, 80, 100, 600, 3, 2, 1};
		System.out.println(findMax(arr,0,arr.length-1));
	}
	
	private static int findMax(int[] arr,int low,int high) {
		if(low==high) {
			return arr[low];
		}
		if(low+1==high && arr[low]>=arr[high]) {
			return arr[low];
		}
		if(low+1==high && arr[high]>arr[low]) {
			return arr[high];
		}
		int mid=low+(high-low)/2;
		if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) {
			return arr[mid];
		}
		if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]) {
			return findMax(arr,low,mid-1);
		}
		else {
			return findMax(arr,mid+1,high);
		}
	}

}
