package knapsack;

public class KnapsackMemoization {
	
	private static int[][] temp=new int[4][51];
	
	public static void main(String[] args) {
		int[] weight= {10,20,30};
		int[] value= {60,100,120};
		int target=50;
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[0].length;j++) {
				temp[i][j]=-1;
			}
		}
		maximumProfitKnapsack(weight,value,target,weight.length);
		System.out.println(temp[weight.length][target]);
	}
	
	private static int maximumProfitKnapsack(int[] weight,int[] value,int target,int length) {
		if(target==0 || length==0) {
			return 0;
		}
		if(temp[length][target]!=-1) {
			return temp[length][target];
		}
		if(weight[length-1]<=target) {
			return temp[length][target]=Math.max(value[length-1]+maximumProfitKnapsack(weight, value, target-weight[length-1], length-1), 
					maximumProfitKnapsack(weight, value, target, length-1));
		}
		return temp[length][target]=maximumProfitKnapsack(weight, value, target, length-1);
	}

}
