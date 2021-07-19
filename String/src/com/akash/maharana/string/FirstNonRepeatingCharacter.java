package com.akash.maharana.string;

public class FirstNonRepeatingCharacter {
	
	public static void main(String[] args) {
		String input="GEEKSFORGEEKS";
		System.out.println(firstNonRepeatingCharacter(input));
	}
	
	private static char firstNonRepeatingCharacter(String input) {
		int[] temp=new int[26];
		for(int i=0;i<temp.length;i++) {
			temp[i]=-1;
		}
		for(int i=0;i<input.length();i++) {
			if(temp[input.charAt(i)-65]==-1 && temp[input.charAt(i)-65]<0) {
				temp[input.charAt(i)-65]=i;
			}
			else if(temp[input.charAt(i)-65]>=0) {
				temp[input.charAt(i)-65]=-2;
			}
		}
		int minimum=Integer.MIN_VALUE;
		for(int i=0;i<temp.length;i++) {
			if(temp[i]>0) {
				if(minimum==Integer.MIN_VALUE && temp[i]>minimum) {
					minimum=temp[i];
				}
				else {
					if(minimum>temp[i]) {
						minimum=temp[i];
					}
				}
			}
		}
		return input.charAt(minimum);
	}

}
