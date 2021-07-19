package com.akash.maharana.array;

public class MaximumDifferenceBetweenTwoElements {
	
	public static void main(String[] args) {
		int[] arr={1, 2, 90, 10, 110};
		System.out.println("Maximum difference is : "+maximumDifference(arr));
	}
	
	private static int maximumDifference(int[] arr) {
		int maximumDifference=arr[1]-arr[0];
		int minimumElement=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]-minimumElement>maximumDifference) {
				maximumDifference=arr[i]-minimumElement;
			}
			if(arr[i]<minimumElement) {
				minimumElement=arr[i];
			}
		}
		return maximumDifference;
	}

}
