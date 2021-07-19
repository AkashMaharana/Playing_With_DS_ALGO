package com.akash.maharana.queue;
import java.util.Stack;

public class GameOfTwoStack {
	
	public static void main(String[] args) {
		Stack<Integer> s1=new Stack<>();
		Stack<Integer> s2=new Stack<>();
		s1.push(1);
		s1.push(6);
		s1.push(4);
		s1.push(2);
		s1.push(4);
		s2.push(2);
		s2.push(1);
		s2.push(8);
		s2.push(5);
		System.out.println(maximumNoOfElement(s1,s2,10));;
	}

	private static int maximumNoOfElement(Stack<Integer> s1, Stack<Integer> s2, int sum) {
		int firstStack=firstStackCombination(s1,s2,sum);
		int secondStack=secondStackCombination(s1,s2,sum);
		return Math.max(firstStack, secondStack);
	}
	
	private static int firstStackCombination(Stack<Integer> s1, Stack<Integer> s2, int sum){
		int noOfElementsPopFromfirst=0;
		while(sum>0){
			if(sum-s1.peek()>=0){
				sum=sum-s1.peek();
				s1.pop();
				noOfElementsPopFromfirst=noOfElementsPopFromfirst+1;
			}
		}
		
		
		return noOfElementsPopFromfirst;
	}
	
	private static int secondStackCombination(Stack<Integer> s1, Stack<Integer> s2, int sum){
		return 0;
	}

}
