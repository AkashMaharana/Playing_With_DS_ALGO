package knapsack;

public class Knapsack {
	
	private int numberOfItems;
	private int capacityOfknapsack;
	private int[][] knapsackTable;
	private int[] weights;
	private int[] values;
	
	public Knapsack(int numberOfItems,int[] weights,int[] values,int capacityOfKnapsack){
		this.numberOfItems=numberOfItems;
		this.weights=weights;
		this.values=values;
		this.capacityOfknapsack=capacityOfKnapsack;
		knapsackTable=new int[numberOfItems+1][capacityOfKnapsack+1];
	}
	
	public void solveKnapsack(){
		for(int i=1;i<numberOfItems+1;i++){
			for(int j=1;j<capacityOfknapsack+1;j++){
				int notTakingItem=knapsackTable[i-1][j];
				int takingItem=0;
				if(weights[i]<=j){
					takingItem=values[i]+knapsackTable[i-1][j-weights[i]];
				}
				knapsackTable[i][j]=Math.max(takingItem, notTakingItem);
			}
		}
		for(int i=0;i<knapsackTable.length;i++) {
			for(int j=0;j<knapsackTable[0].length;j++) {
				System.out.print(knapsackTable[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Total Benefits : "+knapsackTable[numberOfItems][capacityOfknapsack]);
	}
	
	public void showResult(){
		for(int i=numberOfItems, j=capacityOfknapsack;i>0;i--){
			if(knapsackTable[i][j]!=0 && knapsackTable[i][j]!=knapsackTable[i-1][j]){
				System.out.println("Item : "+i);
				j=j-weights[i];
			}
		}
	}

}
