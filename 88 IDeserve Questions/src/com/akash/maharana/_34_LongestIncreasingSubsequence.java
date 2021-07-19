package com.akash.maharana;

public class _34_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = {0,4,12,2,10,6,9,13,3,11,7,15};
		System.out.println("Length of Longest Increasing Subsequence : "+longestIncreasingSubsequence(input));
	}
	
	private static int longestIncreasingSubsequence(int[] input) {
		int[] tempLength=new int[input.length];
		int[] tempIndex=new int[input.length];
		for(int i=0;i<tempLength.length;i++) {
			tempLength[i]=1;
		}
		int j=1;
		int result=0;
		int lastIndex=0;
		while(j<input.length) {
			int i=0;
			while(i<j) {
				if(input[i]<input[j]) {
					if(tempLength[j]<=tempLength[i]+1) {
						tempLength[j]=tempLength[i]+1;
						tempIndex[j]=i;
						i++;
					}
					else {
						i++;
					}
				}
				else {
					i++;
				}
			}
			if(result<tempLength[j]) {
				result=tempLength[j];
				lastIndex=j;
			}
			j++;
		}
		printIncreasingSubsequence(input,tempIndex,lastIndex,result);
		return tempLength[input.length-1];
	}
	
	private static void printIncreasingSubsequence(int[] input,int[] tempIndex,int lastIndex,int result) {
		System.out.print("Longest Subsequence is : ");
		int[] tempArray=new int[result];
		int index=result-2;
		int i=lastIndex;
		tempArray[result-1]=input[i];
		while(i>=0) {
			i=tempIndex[i];
			tempArray[index]=input[i];
			index--;
			if(i==0) {
				break;
			}
		}
		for(int j=0;j<tempArray.length;j++) {
			System.out.print(tempArray[j]+" ");
		}
		System.out.println();
	}

}
