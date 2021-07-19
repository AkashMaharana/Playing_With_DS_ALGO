package com.akash.maharana;

import java.util.Stack;

public class _6_NextGreaterElementInTheArray {
	
	public static void main(String[] args) {
		int[] input= {98,23,54,12,20,7,27};
					//{11, 13, 21, 3}
					//{4, 5, 2, 25}
		nextGreaterElemet(input);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println();
	}
	
	private static void nextGreaterElemet(int[] input) {
		Stack<Integer> temp=new Stack<>();
		for(int i=0;i<input.length;i++) {
			if(temp.isEmpty() || input[temp.peek()]>input[i]) {
				temp.push(i);
			}
			else {
				while(!temp.isEmpty() && input[temp.peek()]<input[i]) {
					input[temp.pop()]=input[i];
				}
				temp.push(i);
			}
		}
		while(!temp.isEmpty()) {
			input[temp.pop()]=0;
		}
	}

}
