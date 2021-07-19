package com.akash.maharana.standardProblems;

import java.util.Stack;

//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/

public class CheckForBalancedParanthesis {

	public static void main(String[] args) {
		char exp[] = { '{', '(', ')', '}', '[', ']' };
		if (areParenthesisBalanced(exp))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

	private static boolean areParenthesisBalanced(char[] exp) {
		Stack<Character> s=new Stack<>();
		for(int i=0;i<exp.length;i++){
			if(exp[i]=='(' || exp[i]=='{' || exp[i]=='['){
				s.push(exp[i]);
			}
			if(exp[i]==')' || exp[i]=='}' || exp[i]==']'){
				if(s.isEmpty()){
					return false;
				}
				else{
					if(!matchingPair(s.pop(),exp[i])){
						return false;
					}	
				}
			}
		}
		if(s.isEmpty()){
			return true;
		}
		else{
			return false;
		}	
	}

	private static boolean matchingPair(char character, Character pop) {
		if(character=='(' && pop==')'){
			return true;
		}
		else if(character=='{' && pop=='}'){
			return true;
		}
		else if(character=='[' && pop==']'){
			return true;
		}
		else{
			return false;
		}
	}

}
