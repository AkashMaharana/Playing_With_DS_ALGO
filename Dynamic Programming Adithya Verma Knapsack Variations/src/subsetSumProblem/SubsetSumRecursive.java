package subsetSumProblem;

public class SubsetSumRecursive {
	
	public static void main(String[] args) {
		int[] input={3, 34, 4, 12, 5, 2};
		int target=51;
		System.out.println("Valid subset is present : "+isValidSubset(input,target,input.length));
	}
	
	private static boolean isValidSubset(int[] input,int target,int length) {
		if(target==0) {
			return true;
		}
		if(length==0 && target!=0) {
			return false;
		}
		if(input[length-1]>target) {
			return isValidSubset(input, target, length-1);
		}
		return isValidSubset(input, target, length-1) || isValidSubset(input, target-input[length-1], length-1);
	}

}
