package com.akash.maharana.array;

public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Largest sum of contiguous sub array is : "+findLargestSum(arr));
		System.out.println("-------------------");
		int[] arr1= {-2,-4,-7};
		System.out.println("Largest sum of contiguous sub array where all the elements are negative : "
				+ ""+findLargestSumWhenAllTheElementsAreNegative(arr1));
	}
	
	private static int findLargestSum(int[] arr) {
		int maximumSoFar=0;
		int maximumEndingHere=0;
		int start=0;
		int end=0;
		int tempStart=0;
		for(int i=0;i<arr.length;i++) {
			maximumEndingHere=maximumEndingHere+arr[i];
			if(maximumEndingHere>maximumSoFar) {
				maximumSoFar=maximumEndingHere;
				start=tempStart;
				end=i;
			}
			if(maximumEndingHere<0) {
				maximumEndingHere=0;
				tempStart=i+1;
			}
		}
		System.out.println("Start Index : "+start);
		System.out.println("End Index : "+end);
		return maximumSoFar;
	}
	
	private static int findLargestSumWhenAllTheElementsAreNegative(int[] arr) {
		int maximumSoFar=arr[0];
		int maximumEndingHere=arr[0];
		for(int i=1;i<arr.length;i++) {
			maximumEndingHere=Math.max(maximumEndingHere, maximumEndingHere+arr[i]);
			maximumSoFar=Math.max(maximumSoFar, maximumEndingHere);
		}
		return maximumSoFar;
	}

}
