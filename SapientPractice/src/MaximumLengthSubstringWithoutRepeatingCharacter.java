import java.util.HashSet;
import java.util.Set;

public class MaximumLengthSubstringWithoutRepeatingCharacter {
	
	public static void main(String[] args) {
		String input="geeksforgeeks";
		System.out.println(maxLengthSubstring(input));
	}
	
	private static int maxLengthSubstring(String input) {
		int j=0;
		int i=0;
		int currentLength=0;
		int maxLength=0;
		Set<Character> charSet=new HashSet<>();
		while(j<input.length()) {
			while(j<input.length() && !charSet.contains(input.charAt(j))) {
				charSet.add(input.charAt(j));
				j++;
			}
			currentLength=(j-i);
			if(maxLength<currentLength) {
				maxLength=currentLength;
			}
			if(j==input.length()) {
				break;
			}
			while(charSet.contains(input.charAt(j))) {
				charSet.remove(input.charAt(i));
				i++;
			}
		}
		return maxLength;	
	}

}
