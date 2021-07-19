package totalNumberOfWaysToMakeADenomination;

public class NumberOfWaysToMakeADenominationDynamicProgramming {

	public static void main(String[] args) {
		int[] input = { 2, 5, 3, 6 };
		int target = 10;
		System.out.println("Total Number of ways to make the denomination : "+totalNumberOfWays(input, target));
	}

	private static int totalNumberOfWays(int[] input, int target) {
		int[][] temp = new int[input.length + 1][target + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = 1;
		}
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				if (input[i - 1] > j) {
					temp[i][j] = temp[i - 1][j];
				} else {
					temp[i][j] = temp[i - 1][j] + temp[i][j - input[i - 1]];
				}
			}
		}
		return temp[input.length][target];
	}

}
