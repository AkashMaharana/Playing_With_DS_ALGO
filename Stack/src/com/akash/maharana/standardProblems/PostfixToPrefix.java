package com.akash.maharana.standardProblems;

import java.util.Stack;

public class PostfixToPrefix {

	public static void main(String[] args) {
		String expression = "*-A/BC-/AKL";
		System.out.println(postfixToPrefix(expression));
	}

	private static String postfixToPrefix(String expression) {
		Stack<String> finalStack = new Stack<>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			if (Character.isLetterOrDigit(expression.charAt(i))) {
				finalStack.push(expression.charAt(i) + "");
			} else {
				while (!finalStack.isEmpty()) {
					String temp = expression.charAt(i) + finalStack.pop() + finalStack.pop();
					finalStack.push(temp);
					break;
				}
			}
		}
		String finalString = "";
		while (!finalStack.isEmpty()) {
			finalString = finalString + finalStack.pop();
		}

		return finalString;
	}

}
