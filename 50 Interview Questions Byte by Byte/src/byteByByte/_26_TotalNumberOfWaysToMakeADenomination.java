package byteByByte;

public class _26_TotalNumberOfWaysToMakeADenomination {
	
	public static void main(String[] args) {
		int[] coins= {2, 5, 3, 6};
		int denominationValue=10;
		System.out.println("Total Number of Ways to Make Denomination : "+totalNumberOfWaysToMakeDenomination(coins,denominationValue));
	}
	
	private static int totalNumberOfWaysToMakeDenomination(int[] coins,int denominationValue) {
		int[][] denominationMatrix=new int[coins.length+1][denominationValue+1];
		for(int i=0;i<denominationMatrix.length;i++) {
			denominationMatrix[i][0]=1;
		}
		for(int i=1;i<denominationMatrix.length;i++) {
			for(int j=1;j<denominationMatrix[i].length;j++) {
				if(j<coins[i-1]) {
					denominationMatrix[i][j]=denominationMatrix[i-1][j];
				}
				else {
					denominationMatrix[i][j]=denominationMatrix[i-1][j]+denominationMatrix[i][j-coins[i-1]];
				}
			}
		}
		return denominationMatrix[coins.length][denominationValue];
	}

}
