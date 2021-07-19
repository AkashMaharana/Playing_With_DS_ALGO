package com.akash.maharana;

public class _9_MaximumAverageSubArrayOfSizeK {
	
	public static void main(String[] args) {
		int[] input= {1, 12, -5, -6, 50, 3};
		int size=2;
		System.out.println("Maximum Average Sum : "+maximumAverageSubArray(input,size));
	}
	
	private static int maximumAverageSubArray(int[] input,int size) {
		int maximumSumSofar=0;
		int maximumSum=0;
		int startIndex=0;
		for(int i=0;i<size;i++) {
			maximumSumSofar=maximumSumSofar+input[i];
		}
		maximumSum=maximumSumSofar;
		int i=size;
		int excludeIndex=0;
		while(i<input.length) {
			maximumSumSofar=maximumSumSofar+input[i]-input[excludeIndex];
			if(maximumSumSofar>maximumSum) {
				maximumSum=maximumSumSofar;
				startIndex=i;
			}
			i++;
			excludeIndex++;
		}
		System.out.println("Strat Index : "+(startIndex-size+1));
		return maximumSum;
	}

}
