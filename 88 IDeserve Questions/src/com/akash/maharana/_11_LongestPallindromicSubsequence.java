package com.akash.maharana;

public class _11_LongestPallindromicSubsequence {

	public static void main(String[] args) {
		String input = "agbdba";
					//BBABCBCAB
		System.out.println("Length of Pallindromic Subsequence DP : "+longestPallindromicSubsequenceLengthDP(input));
		System.out.println("Length of Pallindromic Subsequence Recursion : "
				+ ""+longestPallindromicSubsequenceLengthRecursion(input,0,input.length()-1));
	}

	private static int longestPallindromicSubsequenceLengthDP(String input) {
		int[][] countArray = new int[input.length()][input.length()];
		int i = 0;
		int j = 0;
		while (i < input.length() && j < input.length()) {
			countArray[i][j] = 1;
			i++;
			j++;
		}
		i = 1;
		while (i <= input.length() - 1) {
			int rowCount = 0;
			int columnCount = i;
			while (columnCount <= input.length() - 1) {
				if (input.charAt(rowCount) == input.charAt(columnCount)) {
					countArray[rowCount][columnCount] = 2+ countArray[rowCount+1][columnCount-1];
				} else {
					countArray[rowCount][columnCount] = Math.max(countArray[rowCount][columnCount - 1],
							countArray[rowCount + 1][columnCount]);
				}
				rowCount++;
				columnCount++;
			}
			i++;
		}
		printThePallindromicSubsequence(countArray,input);
		return countArray[0][input.length() - 1];
	}
	
	private static void printThePallindromicSubsequence(int[][] countArray,String input) {
		char[] charArray=new char[countArray[0][countArray.length-1]];
		int startIndex=0;
		int endIndex=charArray.length-1;
		int i=0;
		int j=countArray.length-1;
		while(countArray[i+1][j-1]!=0) {
			if(countArray[i+1][j-1]==countArray[i][j]-2 && countArray[i][j-1]==countArray[i][j]-2 
					&& countArray[i+1][j]==countArray[i][j]-2) {
				charArray[startIndex]=input.charAt(i);
				charArray[endIndex]=input.charAt(j);
				i=i+1;
				j=j-1;
				startIndex++;
				endIndex--;
			}
			else {
				if(Math.max(countArray[i][j-1], countArray[i+1][j])==countArray[i][j-1]) {
					j--;
				}
				else {
					i++;
				}
			}
		}
		if(countArray[i+1][j-1]==0) {
			charArray[startIndex]=input.charAt(i);
		}
		System.out.println("Pallindromic Subsequence : "+String.valueOf(charArray));
	}
	
	private static int longestPallindromicSubsequenceLengthRecursion(String input,int startIndex,int endIndex) {
		if(startIndex==endIndex) {
			return 1;
		}
		if(input.charAt(startIndex)==input.charAt(endIndex) && startIndex+1==endIndex) {
			return 2;
		}
		if(input.charAt(startIndex)==input.charAt(endIndex)) {
			return longestPallindromicSubsequenceLengthRecursion(input, startIndex+1, endIndex-1)+2;
		}
		return Math.max(longestPallindromicSubsequenceLengthRecursion(input, startIndex, endIndex-1), 
				longestPallindromicSubsequenceLengthRecursion(input, startIndex+1, endIndex));
	}

}
