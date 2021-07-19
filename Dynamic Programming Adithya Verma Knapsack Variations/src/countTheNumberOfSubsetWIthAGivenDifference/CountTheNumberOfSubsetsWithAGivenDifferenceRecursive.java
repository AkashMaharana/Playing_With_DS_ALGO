package countTheNumberOfSubsetWIthAGivenDifference;

public class CountTheNumberOfSubsetsWithAGivenDifferenceRecursive {

	public static void main(String[] args) {
		/*int difference=1;
		S1+S2=sum
		S1-S2=difference*/
		int[] input = { 1, 1, 2, 3 };
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum = sum + input[i];
		}
		int target = 4;
		System.out.println("Number of subsets with the given sum : "+countTheNumberOfSubset(input, target, input.length));
	}

	private static int countTheNumberOfSubset(int[] input, int target, int length) {
		if (target == 0) {
			return 1;
		}
		if (target != 0 && length == 0) {
			return 0;
		}
		return countTheNumberOfSubset(input, target - input[length - 1], length - 1)
				+ countTheNumberOfSubset(input, target, length - 1);
	}

}
