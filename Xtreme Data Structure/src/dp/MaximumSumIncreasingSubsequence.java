package dp;

public class MaximumSumIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] input={2,3,1,4,2,6};
		System.out.println("Maximum Sum Increasing Subsequence : "+maximumIncreasingSubsequence(input));
	}
	
	private static int maximumIncreasingSubsequence(int[] input) {
		int[] temp=new int[input.length];
		for(int i=0;i<input.length;i++) {
			temp[i]=input[i];
		}
		int maximumSum=temp[0];
		for(int j=1;j<input.length;j++) {
			int tempIndex=0;
			int maxValueAtIndex=temp[j];
			while(tempIndex<j) {
				if(input[tempIndex]<input[j]) {
					if(maxValueAtIndex<(input[j]+temp[tempIndex])) {
						maxValueAtIndex=input[j]+temp[tempIndex];
					}
				}
				tempIndex++;
			}
			temp[j]=maxValueAtIndex;
			if(maximumSum<maxValueAtIndex) {
				maximumSum=maxValueAtIndex;
			}
		}
		return maximumSum;
	}

}
