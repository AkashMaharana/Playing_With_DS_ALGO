package countOfSubsetsEqualToGivenSum;

public class CountOfSubsetsSumEqualToGivenSumRecursive {
	
	public static void main(String[] args) {
		int[] input={1, 1, 1, 1};
		int target=1;
		System.out.println("Number of subsets with the given sum : "+countOfSubsetSum(input,target,input.length));
	}
	
	private static int countOfSubsetSum(int[] input,int target,int length) {
		if(target==0) {
			return 1;
		}
		if(length==0 && target!=0) {
			return 0;
		}
		return countOfSubsetSum(input, target-input[length-1], length-1) + 
				countOfSubsetSum(input, target, length-1);
	}

}
