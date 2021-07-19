package com.akash.maharana.standardProblems;

import java.util.Stack;

public class StockSpanProblem {
	
	public static void main(String[] args) { 
        int price[] = { 10, 4, 5, 90, 120, 80 }; 
        int n = price.length; 
        int[] outputArray = new int[n]; 
        calculateSpan(price, n, outputArray); 
        printArray(outputArray, n); 
    }

	private static void printArray(int[] s, int n) {
		for(int i=0;i<n;i++){
			System.out.print(s[i]+" ");
		}
	}

	private static void calculateSpan(int[] price, int n, int[] outputArray) {		
		Stack<Integer> indexStack=new Stack<>();
		indexStack.push(0);
		outputArray[0]=1;
		for(int i=1;i<n;i++){
			while(!indexStack.isEmpty() && price[indexStack.peek()]<=price[i]){
				indexStack.pop();
			}
			if(indexStack.isEmpty()){
				outputArray[i]=i+1;
			}
			else{
				outputArray[i]=i-indexStack.peek();
			}
			indexStack.push(i);
		}
	}

}
