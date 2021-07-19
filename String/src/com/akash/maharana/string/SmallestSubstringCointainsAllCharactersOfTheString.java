package com.akash.maharana.string;

public class SmallestSubstringCointainsAllCharactersOfTheString {
	
	public static void main(String[] args) {
		String input="aabcbcdbca";
		System.out.println(smallestWindow(input));
	}
	
	private static String smallestWindow(String input) {
		boolean[] dist=new boolean[256];
		int distinctCount=0;
		for(int i=0;i<input.length();i++) {
			if(dist[input.charAt(i)]==false) {
				dist[input.charAt(i)]=true;
				distinctCount++;
			}
		}
		int minimumLength=Integer.MAX_VALUE;
		int start=0;
		int start_Index=-1;
		int[] count=new int[256];
		int tempCount=0;
		for(int i=0;i<input.length();i++) {
			count[input.charAt(i)]++;
			if(count[input.charAt(i)]==1) {
				tempCount++;
			}
			if(tempCount==distinctCount) {
				while(count[input.charAt(start)]>1) {
					if(count[input.charAt(start)]>1) {
						count[input.charAt(start)]--;
						start++;
					}
				}
				int windowLength=i-start+1;
				if(minimumLength>windowLength) {
					minimumLength=windowLength;
					start_Index=start;
				}
			}
		}
		return input.substring(start_Index,start_Index+minimumLength);
	}

}
