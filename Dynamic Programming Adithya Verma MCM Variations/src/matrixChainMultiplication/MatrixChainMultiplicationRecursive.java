package matrixChainMultiplication;

public class MatrixChainMultiplicationRecursive {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 3 };
		System.out.println("Minimum number of multiplications required : "
				+ minimumNumberOfMultiplication(input, 1, input.length - 1));
	}

	private static int minimumNumberOfMultiplication(int[] input, int i, int j) {
		int minimum=Integer.MAX_VALUE;
		if(i>=j)
		{
			return 0;
		}
		for(int k=i;k<j;k++) {
			int count=minimumNumberOfMultiplication(input, i, k)
					+minimumNumberOfMultiplication(input, k+1, j)
					+input[i-1]*input[k]*input[j];
			if(count<minimum) {
				minimum=count;
			}
		}
		return minimum;
	}
}
