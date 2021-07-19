package byteByByte;

import java.util.HashSet;
import java.util.Set;

public class _4_FindDuplicatesInArray {
	
	/*Find duplicates in an array*/
	
	public static void main(String[] args) {
		int[] inputArray= {1,2,3,2,3,1,6,7};
		Set<Integer> output=new HashSet<>();
		for(int i=0;i<inputArray.length;i++) {
			int index=Math.abs(inputArray[i])-1;
			if(inputArray[index]<0) {
				output.add(Math.abs(inputArray[i]));
			}
			else {
				inputArray[index]=-inputArray[index];
			}
		}
		for(int i=0;i<inputArray.length;i++) {
			inputArray[i]=Math.abs(inputArray[i]);
		}
		for(Integer i : output) {
			System.out.println(i);
		}
	}

}
