package byteByByte;

import java.util.HashSet;
import java.util.Set;

public class _5_LengthOfLongestConsecutiveNumber {
	
	public static void main(String[] args) {
		int[] input= {4,2,1,6,5};
		System.out.println(lengthOfLongestSequence(input));
	}
	
	private static int lengthOfLongestSequence(int[] input) {
		Set<Integer> numSet=new HashSet<>();
		for(int i=0;i<input.length;i++) {
			numSet.add(input[i]);
		}
		int maxLength=0;
		for(int i : input) {
			if(numSet.contains(i-1)) continue;
			int length=0;
			while(numSet.contains(i++)) length++;
			maxLength=Math.max(maxLength, length);
		}
		return maxLength;
	}

}
