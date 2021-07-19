package com.akash.maharana.string;

public class CountNumberOfPossibleDecodingsOfADigitSequence {
	
	public static void main(String[] args) {
		char digits[] = {'1', '3', '3', '4','5','6'}; 
		System.out.println("Number of decodings are by recursive : "+countNumberOfDecodeRecursive(digits,digits.length));
		System.out.println("Number of decodings are by dp : "+countNumberOfDecodeDynamicProgramming("133456"));
	}
	
	private static int countNumberOfDecodeRecursive(char[] digits,int length) {
		if(length==0 || length==1) {
			return 1;
		}
		if(digits[0]=='0') {
			return 0;
		}
		int count=0;
		if(digits[length-1]>'0') {
			count=countNumberOfDecodeRecursive(digits, length-1);
		}
		if(digits[length-2]=='1' || (digits[length-2]=='2' && digits[length-1]<'7')) {
			count=count+countNumberOfDecodeRecursive(digits, length-2);
		}
		return count;
	}
	
	private static int countNumberOfDecodeDynamicProgramming(String input) {
		int[] temp=new int[input.length()+1];
		temp[0]=temp[1]=1;
		for(int i=2;i<input.length()+1;i++) {
			if(input.charAt(i-1)>'0') {
				temp[i]=temp[i-1];
			}
			if(input.charAt(i-2)<'2' || (input.charAt(i-2)=='2' && input.charAt(i-1)<'7')) {
				temp[i]=temp[i]+temp[i-2];
			}
		}
		return temp[input.length()];
	}

}
