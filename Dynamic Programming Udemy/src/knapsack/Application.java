package knapsack;

public class Application {
	
	public static void main(String[] args) {
		int numberOfItems=3;
		int capacityOfKnapsack=5;
		int[] weightOfItems=new int[numberOfItems+1];
		weightOfItems[1]=2;
		weightOfItems[2]=3;
		weightOfItems[3]=4;
		int[] profitOfItems=new int[numberOfItems+1];
		profitOfItems[1]=4;
		profitOfItems[2]=7;
		profitOfItems[3]=10;
		Knapsack knp=new Knapsack(numberOfItems, weightOfItems, profitOfItems, capacityOfKnapsack);
		knp.solveKnapsack();
		knp.showResult();
	}

}
