package byteByByte;

import java.util.LinkedList;
import java.util.Queue;

public class _29_ImplementStackUsingQueue {
	
	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.queue1=new LinkedList<Integer>();
		stack.queue2=new LinkedList<Integer>();
		push(stack,1);
		push(stack,2);
		push(stack,3);
		System.out.println(pop(stack));
		System.out.println(pop(stack));
	}
	
	static void push(Stack stack,int data) {
		enQueue(stack.queue1, data);
	}
	
	static void enQueue(Queue<Integer> queue1,int data) {
		queue1.add(data);
	}
	
	static int pop(Stack stack) {
		int popElement=deQueue(stack);
		if(stack.queue1.isEmpty()) {
			System.out.println("Stack is empty");
		}
		while(stack.queue1.size()>1) {
			stack.queue2.add(stack.queue1.remove());
		}
		stack.queue1.remove();
		Queue<Integer> tempQueue=stack.queue1;
		stack.queue1=stack.queue2;
		stack.queue2=tempQueue;
		return popElement;
	}
	
	static int deQueue(Stack stack) {
		if(stack.queue1.isEmpty()) {
			System.out.println("Stack is underflow");
		}
		while(stack.queue1.size()>1) {
			stack.queue2.add(stack.queue1.remove());
		}
		int temp=stack.queue1.peek();
		stack.queue2.add(stack.queue1.remove());
		
		Queue<Integer> tempQueue=stack.queue1;
		stack.queue1=stack.queue2;
		stack.queue2=tempQueue;
		return temp;
	}
	
	static class Stack{
		Queue<Integer> queue1;
		Queue<Integer> queue2;
	}

}
