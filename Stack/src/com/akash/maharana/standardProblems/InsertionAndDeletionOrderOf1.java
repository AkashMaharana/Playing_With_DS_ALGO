package com.akash.maharana.standardProblems;

import java.util.Stack;

public class InsertionAndDeletionOrderOf1 {
	
	public static void main(String[] args) {
		int[] arr={-19,10,3,5,12,34,-3,-5,-2,6,-7};
		Stack<Integer> s1=new Stack<>();
		Stack<Integer> s2=new Stack<>();
		for(int i=0;i<arr.length;i++){
			if(s1.isEmpty() && s2.isEmpty()){
				s1.push(arr[i]);
				s2.push(arr[i]);
			}
			else{
				if(s2.peek()>arr[i]){
					s1.push(arr[i]);
					s2.push(arr[i]);
				}
				else{
					s1.push(arr[i]);
				}
			}
		}
		System.out.println(getMin(s1,s2));
		System.out.println(getMin(s1,s2));
	}

	private static int getMin(Stack<Integer> s1,Stack<Integer> s2) {
		if(s1.peek()==s2.peek()){
			int minimum=s2.peek();
			s1.pop();
			s2.pop();
			return minimum;
		}
		else{
			return s2.peek();
		}
	}

}
