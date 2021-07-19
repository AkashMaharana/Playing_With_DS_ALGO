package com.akash.maharana;

import java.util.Stack;

public class _32_DesignAStackWithAllOperationsIn_O1 {
	
	private static Stack<Integer> input=new Stack<>();
	
	private static Stack<Integer> minimumStack=new Stack<>();

	public static void main(String[] args) {
		pushToStack(2);pushToStack(-3);pushToStack(1);pushToStack(9);pushToStack(3);pushToStack(2);
		pushToStack(-9);pushToStack(6);
		
		System.out.println(popFromStack());
		System.out.println("Minimum : "+getMinimum());
		
		pushToStack(24);pushToStack(-5);
		
		System.out.println(popFromStack());
		System.out.println(popFromStack());
		System.out.println(popFromStack());
		System.out.println("Minimum : "+getMinimum());
	}
	
	private static void pushToStack(int data) {
		if(input.isEmpty()) {
			input.add(data);
			minimumStack.add(data);
		}
		else {
			if(minimumStack.peek()>=data) {
				minimumStack.add(data);
				input.add(data);
			}
			else {
				input.add(data);
			}
		}
	}
	
	private static int popFromStack() {
		int temp=input.pop();
		while(!minimumStack.isEmpty() && temp<=minimumStack.peek()) {
			if(temp==minimumStack.peek()) {
				minimumStack.pop();
				break;
			}
			minimumStack.pop();
		}
		return temp;
	}
	
	private static int getMinimum() {
		return minimumStack.peek();
	}
	
}
