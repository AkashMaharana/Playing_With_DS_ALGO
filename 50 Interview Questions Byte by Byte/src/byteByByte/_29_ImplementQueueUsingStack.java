package byteByByte;

import java.util.Stack;

public class _29_ImplementQueueUsingStack {
	
	public static void main(String[] args) {
		Queue queue=new Queue();
		queue.stack=new Stack<>();
		enqueue(queue, 1);
		enqueue(queue, 2);
		enqueue(queue, 3);
		System.out.println(dequeue(queue));
		System.out.println(dequeue(queue));
		System.out.println(dequeue(queue));
		System.out.println(dequeue(queue));
	}
	
	static void enqueue(Queue queue,int data) {
		push(queue.stack,data);
	}
	
	static void push(Stack<Integer> stack,int data) {
		stack.push(data);
	}
	
	static int dequeue(Queue queue) {
		int popElement=0;
		int result=0;
		if(queue.stack.isEmpty()) {
			System.out.println("Queue is Empty");
			System.exit(0);
		}
		else if(queue.stack.size()==1) {
			return pop(queue.stack);
		}
		else {
			popElement=pop(queue.stack);
			result=dequeue(queue);
			queue.stack.push(popElement);
			return result;
		}
		return 0;
	}
	
	static int pop(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			System.out.println("Stack is underflow");
			System.exit(0);
		}
		return stack.pop();
	}
	
	static class Queue{
		Stack<Integer> stack;
	}

}
