package knapsack;

public class KnapsackDynamicProgramming {
	
	public static void main(String[] args) {
		int[] weight= {10,20,30};
		int[] value= {60,100,120};
		int target=50;
		System.out.println("Maximum Profit of Knapsack : "+maximumProfitKnapsack(weight,value,target));
	}
	
	private static int maximumProfitKnapsack(int[] weight,int[] value,int target) {
		int[][] temp=new int[weight.length+1][target+1];
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(weight[i-1]>j) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=Math.max(temp[i-1][j], value[i-1]+temp[i-1][j-weight[i-1]]);
				}
			}
		}
		return temp[weight.length][target];
	}

}
