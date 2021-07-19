package targetSum;

public class TargetSumDynamicProgramming {
	
	public static void main(String[] args) {
		int[] input= {1,1,1,1,1};
		//int targetSum=3;
		int difference=4;
		System.out.println("Number of combination with the given difference is : "+countNumberOfSubset(input,difference));
	}
	
	private static int countNumberOfSubset(int[] input,int target) {
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
