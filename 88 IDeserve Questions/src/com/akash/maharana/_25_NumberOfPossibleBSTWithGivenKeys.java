package com.akash.maharana;

public class _25_NumberOfPossibleBSTWithGivenKeys {
	
	public static void main(String[] args) {
		int input=6;
		System.out.println(numberOfBST(input));
	}
	
	private static int numberOfBST(int input) {
		int[] tempMatrix=new int[input+1];
		tempMatrix[0]=1;
		tempMatrix[1]=1;
		if(input==0 || input==1) {
			return 1;
		}
		int result=0;
		for(int temp=2;temp<=input;temp++) {
			int temp1=0;
			int temp2=temp-1;
			while(temp1<temp) {
				result=result+tempMatrix[temp1]*tempMatrix[temp2];
				temp1++;
				temp2--;
			}
			tempMatrix[temp]=result;
			result=0;
		}
		return tempMatrix[input];
	}

}
