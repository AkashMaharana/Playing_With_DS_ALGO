package byteByByte;

public class _26_MinimumNumberOfCoinsRequiredToMakeADenominationWithoutOne {
	
	public static void main(String[] args) {
		int[] coins = {7,2,3,6,1};
		int denominationvalue=13;
		System.out.println("Minimum Number of Coins Required : "+miniumumNumberOfCoinsRequired(coins,denominationvalue));
	}

	private static int miniumumNumberOfCoinsRequired(int[] coins, int denominationvalue) {
		int[] denominationArray=new int[denominationvalue+1];
		int[] indexArray=new int[denominationvalue+1];
		for(int i=1;i<denominationvalue+1;i++) {
			denominationArray[i]=Integer.MAX_VALUE-1;
			indexArray[i]=-1;
		}
		denominationArray[0]=0;
		for(int j=0;j<coins.length;j++) {
			for(int i=1;i<denominationvalue+1;i++) {
				if(i>=coins[j]) {
					if(denominationArray[i-coins[j]]+1<denominationArray[i]) {
						denominationArray[i]=denominationArray[i-coins[j]]+1;
						indexArray[i]=j;
					}
				}
			}
		}
		return denominationArray[denominationvalue];
	}

}
