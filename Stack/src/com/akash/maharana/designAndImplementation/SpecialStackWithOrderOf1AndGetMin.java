package com.akash.maharana.designAndImplementation;

import java.util.Stack;

//https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

public class SpecialStackWithOrderOf1AndGetMin {
	
	public static void main(String[] args) {
		Stack<Integer> s1=new Stack<>();
		Stack<Integer> s2=new Stack<>();
		pushToTheStack(s1,s2,-2);
		pushToTheStack(s1,s2,10);
		pushToTheStack(s1,s2,3);
		pushToTheStack(s1,s2,17);
		pushToTheStack(s1,s2,-8);
		pushToTheStack(s1,s2,-10);
		pushToTheStack(s1,s2,8);
		pushToTheStack(s1,s2,-2);
		popFromTheStack(s1,s2);
		popFromTheStack(s1,s2);
		System.out.println(getMinimumOfstack(s2));
		popFromTheStack(s1, s2);
		popFromTheStack(s1, s2);
		System.out.println(getMinimumOfstack(s2));
	}
	
	public static void pushToTheStack(Stack<Integer> s1,Stack<Integer> s2,int data){
		if((s1.isEmpty() && s2.isEmpty()) || (s2.peek()>=data)){
			s1.push(data);
			s2.push(data);
		}
		else{
			if(s2.peek()<data){
				s1.push(data);
			}
		}
	}
	
	public static void popFromTheStack(Stack<Integer> s1,Stack<Integer> s2){
		if(s1.isEmpty() && s2.isEmpty()){
			System.out.println("Stack is empty");
		}
		else if(s1.peek()>s2.peek()){
			s1.pop();
		}
		else if(s1.peek()<=s2.peek()){
			s1.pop();
			s2.pop();
		}
	}
	
	public static int getMinimumOfstack(Stack<Integer> s2){
		return s2.peek();
	}

}
