package com.akash.maharana.array;

public class MergeTwoSortedArraysWithoutExtraSpace {
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 5, 9, 10, 15, 20}; 
	    int[] arr2 = new int[]{2, 3, 8, 13};
	    merge(arr1,arr2);
	    for(int i=0;i<arr1.length;i++) {
	    	System.out.print(arr1[i]+" ");
	    }
	    System.out.println();
	    for(int i=0;i<arr2.length;i++) {
	    	System.out.print(arr2[i]+" ");
	    }
	}
	
	private static void merge(int[] arr1,int[] arr2) {
		for(int i=arr2.length-1;i>=0;i--) {
			int j;
			int last=arr1[arr1.length-1];
			for(j=arr1.length-2;j>=0 && arr1[j]>arr2[i];j--) {
				arr1[j+1]=arr1[j];
			}
			if(j!=arr1.length-2 || last>arr2[i]) {
				arr1[j+1]=arr2[i];
				arr2[i]=last;
			}
		}
	}

}
