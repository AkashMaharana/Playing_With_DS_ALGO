package byteByByte;

import java.util.Stack;

public class _28_SortAStackUsingStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.add(1);
		stack.add(23);
		stack.add(-2);
		stack.add(7);
		stack.add(13);
		stack.add(95);
		stack.add(25);
		sortStack(stack);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}
	
	private static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int temp=stack.pop();
			sortStack(stack);
			sort(stack,temp);
		}
	}
	
	private static void sort(Stack<Integer> stack,int temp) {
		if(stack.isEmpty() || stack.peek()<temp) {
			stack.push(temp);
		}
		else {
			int tempValue=stack.pop();
			sort(stack,temp);
			stack.push(tempValue);
		}
	}

}
