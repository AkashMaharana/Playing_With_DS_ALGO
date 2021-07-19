package byteByByte;

public class _26_MinimumNumberOfCoinsRequiredToMakeADenomination {
	
	//This solution won't work if denomination of 1 is not there
	
	public static void main(String[] args) {
		int[] coins = {1,5,6,9};
		int denominationvalue=19;
		System.out.println("Minimum Number of Coins Required : "+minimumNumberOfCoinsRequired(coins,denominationvalue));
	}
	
	private static int minimumNumberOfCoinsRequired(int[] coins,int denominationValue) {
		int[][] denominationMatrix=new int[coins.length+1][denominationValue+1];
		for(int i=0;i<denominationValue+1;i++) {
			denominationMatrix[0][i]=i;
		}
		for(int i=1;i<denominationMatrix.length;i++) {
			for(int j=1;j<denominationMatrix[i].length;j++) {
				if(j<coins[i-1]) {
					denominationMatrix[i][j]=denominationMatrix[i-1][j];
				}
				else {
					int nonTakingItem=denominationMatrix[i-1][j];
					int takingItem=denominationMatrix[i][j-coins[i-1]]+1;
					denominationMatrix[i][j]=Math.min(nonTakingItem, takingItem);
				}
			}
		}
		return denominationMatrix[coins.length][denominationValue];
	}

}
