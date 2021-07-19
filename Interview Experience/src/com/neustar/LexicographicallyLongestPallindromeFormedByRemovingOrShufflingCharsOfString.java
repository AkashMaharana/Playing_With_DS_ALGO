package com.neustar;

// https://www.geeksforgeeks.org/find-longest-palindrome-formed-by-removing-or-shuffling-chars-from-string/

public class LexicographicallyLongestPallindromeFormedByRemovingOrShufflingCharsOfString {
	
	public static void main(String[] args) {
		String input="asadasksd";
		System.out.println(printLexicographicallyLongestPallindrome(input));
	}

	private static String printLexicographicallyLongestPallindrome(String input) {
		int[] count=new int[256];
		for(int i=0;i<input.length();i++) {
			count[input.charAt(i)]++;
		}
		String start="";
		String middle="";
		String end="";
		
		for(char ch='a';ch<='z';ch++) {
			if(count[ch]%2==1) {
				if(middle.length()==0) {
					middle=String.valueOf(ch);
				}
				count[ch--]--;
			}
			else {
				for(int i=0;i<count[ch]/2;i++) {
					start+=ch;
				}
			}
		}
		end=reverse(start);
		return start+middle+end;
	}
	
	private static String reverse(String input) {
		String result="";
		char[] temp=input.toCharArray();
		for(int i=temp.length-1;i>=0;i--) {
			result+=temp[i];
		}
		return result;
	}

}
