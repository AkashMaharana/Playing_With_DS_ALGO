package com.akash.maharana.standardProblems;

import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/

public class NextGreaterElement {
	
	public static void main(String args[]) 
    { 
        int arr[]= {11,13,21,3};  
        printNGE(arr); 
    }

	private static void printNGE(int[] arr) {
		Stack<Integer> s=new Stack<>();
		int[] outputArray=new int[arr.length];
		s.push(0);
		for(int i=1;i<=arr.length-1;i++){
			while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
				outputArray[s.peek()]=arr[i];
				s.pop();
			}
			s.push(i);
		}
		while(!s.isEmpty()){
			outputArray[s.pop()]=-1;
		}
		outputArray[arr.length-1]=-1;
		for(int i : outputArray){
			System.out.print(i+" ");
		}
	}

}
