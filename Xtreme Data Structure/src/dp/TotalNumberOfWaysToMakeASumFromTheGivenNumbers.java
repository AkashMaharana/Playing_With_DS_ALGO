package dp;

public class TotalNumberOfWaysToMakeASumFromTheGivenNumbers {
	
	public static void main(String[] args) {
		int[] input= {2, 5, 3, 6};
		int total=10;
		System.out.println("Total number of ways to make the sum : "+calculateNumberOfWays(input,total));
	}
	
	private static int calculateNumberOfWays(int[] input,int total) {
		int[][] temp=new int[input.length+1][total+1];
		for(int i=0;i<temp.length;i++) {
			temp[i][0]=1;
		}
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(j<input[i-1]) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=temp[i-1][j]+temp[i][j-input[i-1]];
				}
			}
		}
		return temp[input.length][total];
	}

}
