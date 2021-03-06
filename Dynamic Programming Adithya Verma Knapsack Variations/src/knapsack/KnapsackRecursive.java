package knapsack;

public class KnapsackRecursive {
	
	public static void main(String[] args) {
		int[] weight= {10,20,30};
		int[] value= {60,100,120};
		int target=70;
		System.out.println("Maximum profit for 50 kg knapsack is : "+maximumProfitKnapsack(weight,value,target,weight.length));
	}
	
	private static int maximumProfitKnapsack(int[] weight,int[] value,int target,int length) {
		if(length==0 || target==0) {
			return 0;
		}
		if(weight[length-1]<=target) {
			return Math.max(value[length-1]+maximumProfitKnapsack(weight, value, target-weight[length-1], length-1),
					maximumProfitKnapsack(weight, value, target, length-1));
		}
		return maximumProfitKnapsack(weight, value, target, length-1);
	}

}
