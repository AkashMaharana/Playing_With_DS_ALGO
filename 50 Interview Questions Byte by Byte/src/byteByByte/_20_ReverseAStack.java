package byteByByte;

import java.util.Stack;

public class _20_ReverseAStack {
	
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.add(1);
		s.add(2);
		s.add(3);
		reverseStack(s);
		printStack(s);
	}
	
	private static Stack<Integer> reverseStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return s;
		}
		int data=s.pop();
		s=reverseStack(s);
		s=addToStack(s,data);
		return s;
	}
	
	private static Stack<Integer> addToStack(Stack<Integer> s,int data){
		if(s.isEmpty()) {
			s.add(data);
			return s;
		}
		int temp=s.pop();
		s=addToStack(s, data);
		s.add(temp);
		return s;
	}
	
	private static void printStack(Stack<Integer> s) {
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		System.out.println();
	}
	

}
