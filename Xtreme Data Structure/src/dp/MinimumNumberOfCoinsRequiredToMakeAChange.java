package dp;

public class MinimumNumberOfCoinsRequiredToMakeAChange {
	
	public static void main(String[] args) {
		int[] coins={9, 6, 5, 1};
		int target=11;
		System.out.println("Minimum number of coins required to make the change : "
				+ ""+calculateMinimumNumberOfCoins(coins,target));
	}
	
	private static int calculateMinimumNumberOfCoins(int[] coins,int target) {
		int[] temp=new int[target+1];
		for(int i=1;i<temp.length;i++) {
			temp[i]=Integer.MAX_VALUE-1;
		}
		temp[0]=0;
		for(int i=0;i<coins.length;i++) {
			for(int j=1;j<temp.length;j++) {
				if(j>=coins[i]) {
					if(temp[j]>(1+temp[j-coins[i]])) {
						temp[j]=1+temp[j-coins[i]];
					}
				}
			}
		}
		return temp[target];
	}

}
