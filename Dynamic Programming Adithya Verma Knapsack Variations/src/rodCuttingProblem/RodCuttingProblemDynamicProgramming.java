package rodCuttingProblem;

public class RodCuttingProblemDynamicProgramming {

	public static void main(String[] args) {
		int[] input = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println("Maximum Obtainable Value is " + maximumProfitInCuttingRods(input, input.length));
	}

	private static int maximumProfitInCuttingRods(int[] input, int length) {
		int[][] temp=new int[input.length+1][length+1];
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(i>j) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=Math.max(temp[i-1][j], input[i-1]+temp[i][j-i]);
				}
			}
		}
		return temp[input.length][length];
	}

}
