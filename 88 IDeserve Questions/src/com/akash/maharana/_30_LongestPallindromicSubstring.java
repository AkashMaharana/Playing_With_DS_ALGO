package com.akash.maharana;

public class _30_LongestPallindromicSubstring {
	
	public static void main(String[] args) {
		String input="forgeeksskeegfor";
		System.out.println("Longest Pallindromic Substring : "+longestPallindromicSubstring(input));
	}
	
	private static String longestPallindromicSubstring(String input) {
		boolean[][] tempMatrix=new boolean[input.length()][input.length()];
		int i=0;
		int j=0;
		String result="";
		while(i<input.length() && j<input.length()) {
			tempMatrix[i][j]=true;
			i++;
			j++;
		}
		for(int temp1=0;temp1<input.length()-2;temp1++) {
			if(input.charAt(temp1)==input.charAt(temp1+1)) {
				tempMatrix[temp1][temp1+1]=true;
				result=input.substring(temp1,temp1+2);
			}
		}
		int temp2=2;
		while(temp2<input.length()-1){
			int rowCount=0;
			int columnCount=temp2;
			while(columnCount<input.length()) {
				if(input.charAt(rowCount)==input.charAt(columnCount) && tempMatrix[rowCount+1][columnCount-1]) {
					tempMatrix[rowCount][columnCount]=true;
					result=input.substring(rowCount,columnCount+1);
				}
				rowCount++;
				columnCount++;
			}
			temp2++;
		}
		return result;
		
	}

}
