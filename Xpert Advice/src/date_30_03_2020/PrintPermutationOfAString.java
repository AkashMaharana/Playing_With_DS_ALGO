package date_30_03_2020;

import java.util.HashSet;
import java.util.Set;

public class PrintPermutationOfAString {
	
	private static Set<String> output=new HashSet<>();
	
	public static void main(String[] args) {
		String input="abbb";
		printAllPermutation(input,0,input.length()-1);
		printAllDistinctPermutation(input,0,input.length()-1);
		System.out.println("Number of distinct permutation : "+output.size());
	}
	
	private static void printAllDistinctPermutation(String input,int startIndex,int endIndex) {
		if(startIndex==endIndex) {
			output.add(input);
			return;
		}
		for(int i=startIndex;i<=endIndex;i++) {
			input=swap(input,startIndex,i);
			printAllDistinctPermutation(input, startIndex+1, endIndex);
			input=swap(input,startIndex,i);
		}
	}
	
	private static void printAllPermutation(String input,int startIndex,int endIndex) {
		if(startIndex==endIndex) {
			System.out.println(input);
			return;
		}
		for(int i=startIndex;i<=endIndex;i++) {
			input=swap(input,startIndex,i);
			printAllPermutation(input, startIndex+1, endIndex);
			input=swap(input,startIndex,i);
		}
	}
	
	private static String swap(String input,int firstIndex,int secondIndex) {
		char[] ch=input.toCharArray();
		char char1=ch[firstIndex];
		ch[firstIndex]=ch[secondIndex];
		ch[secondIndex]=char1;
		return String.valueOf(ch);
	}

}
