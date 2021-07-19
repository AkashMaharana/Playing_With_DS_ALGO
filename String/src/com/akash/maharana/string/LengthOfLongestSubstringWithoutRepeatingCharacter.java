package com.akash.maharana.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringWithoutRepeatingCharacter {
	
	public static void main(String[] args) {
		String input="qwertqwer";
		System.out.println("Length of longest substring : "+lengthOfLongestSubstring(input));
	}
	
	private static int lengthOfLongestSubstring(String input) {
		int start=0;
		int end=0;
		int length=0;
		Map<Character,Integer> map=new HashMap<>();
		while(end<input.length()) {
			if(map.containsKey(input.charAt(end))) {
				start=Math.max(start, map.get(input.charAt(end))+1);
			}
			map.put(input.charAt(end), end);
			length=length<(end-start)+1?(end-start)+1:length;
			end++;
		}
		return length;
	}

}
