package countTheNumberOfSubsetWIthAGivenDifference;

public class CountTheNumberOfSubsetsWithAGivenDifferenceDynamicProgramming {
	
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
		System.out.println("Number of subsets with the given sum : "+countTheNumberOfSubset(input, target));
	}

	private static int countTheNumberOfSubset(int[] input, int target) {
		int[][] temp=new int[input.length+1][target+1];
		for(int i=0;i<temp.length;i++) {
			temp[i][0]=1;
		}
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(input[i-1]>j) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=temp[i-1][j]+temp[i-1][j-input[i-1]];
				}
			}
		}
		return temp[input.length][target];
	}

}
