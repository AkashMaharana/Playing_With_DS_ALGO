package byteByByte;

public class _2_Knapsack {
	
	/*0/1 Knapsack*/

	public static void main(String[] args) {
		int value[] = new int[] { 60, 100, 120 };
		int weight[] = new int[] { 10, 20, 30 };
		System.out.println(knapsack(value, weight, 50));
	}

	private static int knapsack(int[] value, int[] weight, int target) {
		int[][] knapsackTable = new int[weight.length + 1][target + 1];
		for (int i = 1; i < knapsackTable.length; i++) {
			for (int j = 1; j < knapsackTable[i].length; j++) {
				int notTakingItem = knapsackTable[i - 1][j];
				int takingItem = 0;
				if (j >= weight[i - 1]) {
					takingItem = knapsackTable[i - 1][j - weight[i - 1]] + value[i - 1];
				}
				knapsackTable[i][j] = Math.max(takingItem, notTakingItem);
			}
		}
		for (int i = 0; i < knapsackTable.length; i++) {
			for (int j = 0; j < knapsackTable[i].length; j++) {
				System.out.print(knapsackTable[i][j] + " ");
			}
			System.out.println();
		}
		return knapsackTable[weight.length][target];
	}

}
