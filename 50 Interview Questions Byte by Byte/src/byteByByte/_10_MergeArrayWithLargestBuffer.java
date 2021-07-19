package byteByByte;

public class _10_MergeArrayWithLargestBuffer {
	
	private static int NA=-1;
	
	public static void main(String[] args) {
		int[] input1 = {5, 7, 8, 10, 12, NA, NA, NA, NA, NA};
		int[] input2 = {1, 3, 4, 6, 9};
		printArray(input1);
		mergeToHighestBuffer(input1,input2);
		printArray(input1);
	}
	
	private static void mergeToHighestBuffer(int[] input1,int[] input2) {
		int i=input2.length-1;
		int j=input2.length-1;
		int lastIndex=input1.length-1;
		while(j>=0) {
			if(i>=0) {
				if(input1[i]<input2[j]) {
					input1[lastIndex]=input2[j];
					j--;
				}
				else {
					input1[lastIndex]=input1[i];
					i--;
				}
			}
			else {
				input1[lastIndex]=input2[j];
				j--;
			}
			lastIndex--;
		}
	}
	
	private static void printArray(int[] input) {
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println();
	}

}
