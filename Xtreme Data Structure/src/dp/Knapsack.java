package dp;

public class Knapsack {

	public static void main(String[] args) {
		int[] weight = { 10, 20, 30, 50};
		int[] value = { 60, 100, 120, 200 };
		System.out.println("Maximum cost of Knapsack : "+maximumCost(weight,value,60));
	}
	
	private static int maximumCost(int[] weight,int[] value,int target) {
		int[][] temp=new int[weight.length+1][target+1];
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(j<weight[i-1]) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=Math.max(temp[i-1][j], (value[i-1]+temp[i-1][j-weight[i-1]]));
				}
			}
		}
		return temp[weight.length][target];
	}

}
