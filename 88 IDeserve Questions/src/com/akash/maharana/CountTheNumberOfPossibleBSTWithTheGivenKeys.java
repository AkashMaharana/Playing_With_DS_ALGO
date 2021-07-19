package com.akash.maharana;

public class CountTheNumberOfPossibleBSTWithTheGivenKeys {
	
	public static void main(String[] args) {
		int noOfkeys=5;
		System.out.println("Total number of combinations : "+countTheNumberOfPossibility(noOfkeys));
	}
	
	private static int countTheNumberOfPossibility(int noOfKeys) {
		int[] countArray=new int[noOfKeys+1];
		countArray[0]=1;
		countArray[1]=1;
		for(int i=2;i<=noOfKeys;i++) {
			for(int j=0;j<i;j++) {
				countArray[i]=countArray[i]+(countArray[j]*countArray[i-j-1]);
			}
		}
		return countArray[noOfKeys];
	}

}
