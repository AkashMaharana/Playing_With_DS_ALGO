package com.akash.maharana.standardProblems;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(exp));
	}

	private static String infixToPostfix(String exp) {
		String finalString="";
		Stack<Character> charStack=new Stack<>();
		for(int i=0;i<exp.length();i++){
			char ch=exp.charAt(i);
			if(Character.isLetterOrDigit(ch)){
				finalString=finalString+ch;
			}
			else if(ch=='('){
				charStack.push('(');
			}
			else if(ch==')'){
				while(!charStack.isEmpty() && charStack.peek()!='('){
					finalString=finalString+charStack.pop();
				}
				if(!charStack.isEmpty() && charStack.peek()!='('){
					return "Invalid Expression";
				}
				else{
					charStack.pop();
				}
			}
			else{
				while(!charStack.isEmpty() && precedence(ch)<=precedence(charStack.peek())){
					if(charStack.peek()=='('){
						return "Invalid Expression";
					}
					finalString=finalString+charStack.pop();
				}
				charStack.push(ch);
				
			}
		}
		
		while(!charStack.isEmpty()){
			if(charStack.peek()=='('){
				return "Invalid Expression";
			}
			finalString=finalString+charStack.pop();
		}
		
		return finalString;
	}
	
	private static int precedence(char ch){
		switch(ch){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
		}
		return -1;
	}

}
