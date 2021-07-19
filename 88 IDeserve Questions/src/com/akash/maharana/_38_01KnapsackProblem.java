package com.akash.maharana;

public class _38_01KnapsackProblem {

	public static void main(String[] args) {
		int[] weight = { 4, 2, 3 };
		int[] value = { 10, 4, 7 };
		int desiredWeight = 5;
		System.out.println("Maximum profit : "+maximumProfit(weight,value,desiredWeight));
	}
	
	private static int maximumProfit(int[] weight,int [] value,int desiredWeight) {
		int[][] tempArray=new int[weight.length+1][desiredWeight+1];
		for(int i=1;i<tempArray.length;i++) {
			for(int j=1;j<tempArray[i].length;j++) {
				int notTakingItem=tempArray[i-1][j];
				int takingItem=0;
				if(j>=weight[i-1]) {
					takingItem=value[i-1]+tempArray[i-1][j-weight[i-1]];
				}
				tempArray[i][j]=Math.max(notTakingItem, takingItem);
			}
		}
		findWeights(tempArray,weight);
		return tempArray[weight.length][desiredWeight];
	}
	
	private static void findWeights(int[][] tempArray,int[] weight) {
		System.out.print("Weights are : ");
		int i=tempArray.length-1;
		int j=tempArray[0].length-1;
		while(i>0 || j>0) {
			if(tempArray[i][j]==tempArray[i-1][j]) {
				i--;
			}
			else {
				System.out.print(weight[i-1]+" ");
				j=j-weight[i-1];
			}
		}
		System.out.println();
	}

}
