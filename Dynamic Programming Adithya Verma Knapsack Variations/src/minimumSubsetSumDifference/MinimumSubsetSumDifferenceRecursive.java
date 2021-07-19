package minimumSubsetSumDifference;

public class MinimumSubsetSumDifferenceRecursive {
	
	public static void main(String[] args) {
		int[] input={1, 6, 11, 5};
		int totalSum=0;
		for(int i=0;i<input.length;i++) {
			totalSum=totalSum+input[i];
		}
		System.out.println("Minimum difference between all subsets : "+minimumSubsetSumDifference(input,totalSum,input.length,0));
	}
	
	private static int minimumSubsetSumDifference(int[] input,int totalSum,int length,int tempSum) {
		if(length==0) {
			return Math.abs((totalSum-tempSum)-tempSum);
		}
		return Math.min(minimumSubsetSumDifference(input, totalSum, length-1, tempSum+input[length-1]), 
				minimumSubsetSumDifference(input, totalSum, length-1, tempSum));
	}

}
