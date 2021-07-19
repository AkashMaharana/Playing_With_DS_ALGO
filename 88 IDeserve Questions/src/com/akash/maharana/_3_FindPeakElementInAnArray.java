package com.akash.maharana;

public class _3_FindPeakElementInAnArray {

	public static void main(String[] args) {
		int[] input = { 40, 10, 20, 5, 45, 50, 65, 90, 35, 25 };
		System.out.println("Peak Element : "+findPeakElement(input, 0, input.length - 1));
	}

	private static int findPeakElement(int[] input, int start, int end) {
		int mid=start+(end-start)/2;
		if((mid==0 || input[mid-1]<=input[mid]) && (mid==input.length-1 || input[mid+1]<=input[mid])) {
			return input[mid];
		}
		else if(mid>0 && input[mid-1]>input[mid]) {
			return findPeakElement(input, start, mid-1);
		}
		else {
			return findPeakElement(input, mid+1, end);
		}
	}

}
