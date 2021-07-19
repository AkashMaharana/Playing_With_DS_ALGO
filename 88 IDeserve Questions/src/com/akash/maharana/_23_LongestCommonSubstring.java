package com.akash.maharana;

public class _23_LongestCommonSubstring {
	
	public static void main(String[] args) {
		String input1="LCLC";
		String input2="CLCL";
		System.out.println("Length of longest common substring dp : "+longestCommonSubstringDP(input1,input2));
		System.out.println("length of longest common substring recursion : "+
							longestCommonSubstringRecursion(input1.length(), input2.length(), 0, input1, input2));
	}
	
	private static int longestCommonSubstringDP(String input1,String input2) {
		int maxLength=0;
		int rowIndex=0;
		int columnIndex=0;
		int[][] temp=new int[input1.length()+1][input2.length()+1];
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[i].length;j++) {
				if(input1.charAt(i-1)==input2.charAt(j-1)) {
					temp[i][j]=1+temp[i-1][j-1];
					if(temp[i][j]>=maxLength) {
						maxLength=temp[i][j];
						rowIndex=i;
						columnIndex=j;
					}
				}
				else {
					temp[i][j]=0;
				}
			}
		}
		printLongestCommonSubstring(temp,rowIndex,columnIndex,input1,input2);
		return maxLength;
	}
	
	private static void printLongestCommonSubstring(int[][] temp,int rowIndex,int columnIndex,String input1,String input2) {
		StringBuffer sb=new StringBuffer();
		while(temp[rowIndex][columnIndex]!=0) {
			sb.append(input1.charAt(columnIndex-1));
			rowIndex--;
			columnIndex--;
		}
		System.out.println("Longest Common Substring : "+sb.reverse());
	}
	
	private static int longestCommonSubstringRecursion(int firstIndex,int secondIndex,int count,String input1,String input2) {
		if(firstIndex==0 || secondIndex==0) {
			return count;
		}
		if(input1.charAt(firstIndex-1)==input2.charAt(secondIndex-1)) {
			count=longestCommonSubstringRecursion(firstIndex-1, secondIndex-1, count+1, input1, input2);
		}
		count=Math.max(count, Math.max(longestCommonSubstringRecursion(firstIndex-1, secondIndex, 0, input1, input2), 
				longestCommonSubstringRecursion(firstIndex, secondIndex-1, 0, input1, input2)));
		return count;
	}

}
