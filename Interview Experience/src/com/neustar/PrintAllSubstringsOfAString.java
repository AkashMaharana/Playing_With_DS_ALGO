package com.neustar;

public class PrintAllSubstringsOfAString {
	
	public static void main(String[] args) {
		printAllSubstrings("akash");
	}
	
	private static void printAllSubstrings(String string) {
		for(int i=0;i<string.length();i++) {
			for(int j=i+1;j<=string.length();j++) {
				System.out.println(string.substring(i,j));
			}
		}
	}

}
