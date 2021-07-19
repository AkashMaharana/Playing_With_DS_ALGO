package stack;

import java.util.Stack;

public class SortAStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.add(2);
		stack.add(-4);
		stack.add(3);
		stack.add(5);
		stack.add(8);
		stack.add(-7);
		sortStack(stack);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	private static void sortStack(Stack<Integer> stack) {
		if(stack.size()==0) {
			return;
		}
		int temp=stack.pop();
		sortStack(stack);
		sort(stack,temp);
	}
	
	private static void sort(Stack<Integer> stack,int temp) {
		if(stack.isEmpty() || stack.peek()>temp) {
			stack.push(temp);
			return;
		}
		int temp1=stack.pop();
		sort(stack,temp);
		stack.push(temp1);
	}

}
