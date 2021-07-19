package subsetSumProblem;

public class SubsetSumDynamicProgramming {
	
	public static void main(String[] args) {
		int[] input={3, 34, 4, 12, 5, 2};
		int target=1;
		System.out.println("Valid subset is present : "+isValidSubset(input,target));
	}
	
	private static boolean isValidSubset(int[] input,int target) {
		boolean[][] temp=new boolean[input.length+1][target+1];
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
		return temp[input.length][target];
	}

}
