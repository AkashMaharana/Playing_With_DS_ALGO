package coinChanging;

public class MinimumNumberOfCoinsToMakeASum {

	private int count;

	public int getCount() {
		return count;
	}

	public void minimumNumberOfwaysDP(int[] coins, int total) {
		int[] T = new int[total + 1];
		int[] R = new int[total + 1];
		T[0] = 0;
		for (int i = 1; i < T.length; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			R[i] = -1;
		}
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= total; i++) {
				if (i >= coins[j]) {
					if (T[i] > (1 + (T[i - coins[j]]))) {
						T[i] = 1 + T[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}
		System.out.println("Minimum Number of Coin(s) Required : " + T[total]);
		printCoins(coins, R);
	}

	private void printCoins(int[] coins, int[] R) {
		if (R[R.length - 1] == -1) {
			System.out.println("No solution possible");
		}
		int start = R.length - 1;
		System.out.print("Coins used to form total : ");
		while (start != 0) {
			int j = R[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
	}

	public int minimumNumberOfWaysRecursive(int[] coins, int total) {
		count++;
		if (total == 0) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= total) {
				int subResult = minimumNumberOfWaysRecursive(coins, total - coins[i]);
				if (subResult != Integer.MAX_VALUE && subResult + 1 < result) {
					result = subResult + 1;
				}
			}
		}
		return result;
	}

}
