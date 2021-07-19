package com.akash.maharana.standardProblems;

import java.util.Stack;

public class PrefixToPostfix {
	
	public static void main(String[] args) {
		String expression = "*-A/BC-/AKL";
		System.out.println(prefixTopostfix(expression));
	}

	private static String prefixTopostfix(String expression) {
		Stack<String> finalStack=new Stack<>();
		for(int i=expression.length()-1;i>=0;i--){
			if(Character.isLetterOrDigit(expression.charAt(i))){
				finalStack.push(expression.charAt(i)+"");
			}
			else{
				while(!finalStack.isEmpty()){
					String temp=finalStack.pop()+finalStack.pop()+expression.charAt(i);
					finalStack.push(temp);
					break;
				}
			}
		}
		String finalString="";
		while(!finalStack.isEmpty()){
			finalString=finalString+finalStack.pop();
		}
		
		return finalString;
	}

}
