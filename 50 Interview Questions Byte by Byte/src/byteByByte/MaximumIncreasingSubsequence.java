package byteByByte;

public class MaximumIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] input={50, 3,  7, 40, 80};
		System.out.println(maximumIncreasingSubsequence(input));
	}
	
	private static int maximumIncreasingSubsequence(int[] inputArray) {
		int[] temp=new int[inputArray.length];
		for(int i=0;i<temp.length;i++) {
			temp[i]=1;
		}
		for(int i=1;i<inputArray.length;i++) {
			int j=0;
			while(j<i) {
				if(inputArray[j]>inputArray[i]) {
					j++;
					continue;
				}
				else {
					temp[i]=Math.max(temp[i], temp[j]+1);
				}
				j++;
			}
		}
		return temp[temp.length-1];
	}

}
