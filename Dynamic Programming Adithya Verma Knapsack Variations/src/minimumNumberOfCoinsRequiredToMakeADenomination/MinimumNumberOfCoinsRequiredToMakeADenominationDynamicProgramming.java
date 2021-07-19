package minimumNumberOfCoinsRequiredToMakeADenomination;

public class MinimumNumberOfCoinsRequiredToMakeADenominationDynamicProgramming {

	public static void main(String[] args) {
		int[] input = {9, 6, 5, 1};
		int target = 6;
		System.out.println(
				"Minimum number of coins required to make a denomination : " + minimumNumberofCoins(input, target));
	}

	private static int minimumNumberofCoins(int[] input, int target) {
		int[][] temp=new int[input.length+1][target+1];
		for(int i=0;i<temp[0].length;i++) {
			temp[0][i]=Integer.MAX_VALUE-1;
		}
		for(int i=1;i<temp[0].length;i++) {
			if(i%input[0]==0) {
				temp[1][i]=i/input[0];
			}
			else {
				temp[1][i]=Integer.MAX_VALUE-1;
			}
		}
		for(int i=2;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(input[i-1]>j) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=Math.min(temp[i-1][j], (1+temp[i][j-input[i-1]]));
				}
			}
		}
		return temp[input.length][target];
	}

}
