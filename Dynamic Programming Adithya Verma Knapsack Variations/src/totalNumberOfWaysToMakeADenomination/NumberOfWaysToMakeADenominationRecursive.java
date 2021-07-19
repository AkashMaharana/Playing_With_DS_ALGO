package totalNumberOfWaysToMakeADenomination;

public class NumberOfWaysToMakeADenominationRecursive {

	public static void main(String[] args) {
		int[] input = { 2, 5, 3, 6 };
		int target = 10;
		System.out.println(
				"Total Number of ways to make the denomination : " + totalNumberOfWays(input, target, input.length));
	}

	private static int totalNumberOfWays(int[] input, int target, int length) {
		if (target == 0) {
			return 1;
		}
		if(target<0) {
			return 0;
		}
		if(length<=0 && target>=1) {
			return 0;
		}
		return totalNumberOfWays(input, target - input[length - 1], length)
				+ totalNumberOfWays(input, target, length - 1);
	}

}
