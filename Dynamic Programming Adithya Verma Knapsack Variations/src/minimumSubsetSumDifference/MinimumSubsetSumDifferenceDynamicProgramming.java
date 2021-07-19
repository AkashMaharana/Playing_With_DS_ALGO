package minimumSubsetSumDifference;

public class MinimumSubsetSumDifferenceDynamicProgramming {
	
	public static void main(String[] args) {
		int[] input={1, 6, 11, 5};
		System.out.println("Minimum difference between all subsets : "+minimumSubsetSumDifference(input));
	}
	
	private static int minimumSubsetSumDifference(int[] input) {
		int totalSum=0;
		for(int i=0;i<input.length;i++) {
			totalSum=totalSum+input[i];
		}
		boolean[][] temp=new boolean[input.length+1][totalSum+1];
		for(int i=0;i<temp.length;i++) {
			temp[i][0]=true;
		}
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(input[i-1]>j) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=temp[i-1][j] || temp[i-1][j-input[i-1]];
				}
			}
		}
		int diff=Integer.MAX_VALUE;
		for(int i=totalSum/2;i>=0;i--) {
			if(temp[input.length][i]==true) {
				diff=totalSum-2*i;
				break;
			}
		}
		return diff;
	}

}
