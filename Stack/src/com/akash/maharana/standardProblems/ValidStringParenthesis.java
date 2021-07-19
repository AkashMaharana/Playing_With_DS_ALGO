package com.akash.maharana.standardProblems;

import java.util.Stack;

public class ValidStringParenthesis {
	
	public static void main(String[] args) {
		String s="{{{}}}[]";
		System.out.println(validString(s));
	}

	private static boolean validString(String s) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{'){
				stack.push(s.charAt(i));
			}
			else{
				if(!stack.isEmpty()){
					if(s.charAt(i)==']' || s.charAt(i)==')' || s.charAt(i)=='}'){
						if(!isMatched(stack.pop(),s.charAt(i))){
							return false;
						}
					}
				}
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	private static boolean isMatched(char open,char close){
		if(open=='(' && close==')'){
			return true;
		}
		else if(open=='[' && close==']'){
			return true;
		}
		else if(open=='{' && close=='}'){
			return true;
		}
		else{
			return false;
		}
	}

}
