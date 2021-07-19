import java.util.Stack;

public class SortAStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.push(12);
		stack.push(-9);
		stack.push(34);
		stack.push(89);
		stack.push(23);
		stack.push(19);
		sortStack(stack);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	private static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int x=0;
		if(!stack.isEmpty()) {
			x=stack.pop();
			sortStack(stack);
		}
		insertData(stack,x);
		return;
	}
	
	private static void insertData(Stack<Integer> stack,int data) {
		int x=0;
		if(stack.isEmpty() || stack.peek()>=data) {
			stack.push(data);
			return;
		}
		if(stack.peek()<data) {
			x=stack.pop();
			insertData(stack, data);
			stack.push(x);
			return;
		}
	}

}
