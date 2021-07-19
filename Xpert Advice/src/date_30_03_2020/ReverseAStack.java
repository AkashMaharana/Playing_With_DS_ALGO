package date_30_03_2020;

import java.util.Stack;

public class ReverseAStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		reverseStack(stack);
		printStack(stack);
	}
	
	private static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int temp=stack.pop();
		reverseStack(stack);
		pushToStack(stack,temp);
	}
	
	private static void pushToStack(Stack<Integer> stack,int number) {
		if(stack.isEmpty()) {
			stack.push(number);
			return;
		}
		int temp=stack.pop();
		pushToStack(stack, number);
		stack.push(temp);
	}
	
	private static void printStack(Stack<Integer> stack) {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}

}
