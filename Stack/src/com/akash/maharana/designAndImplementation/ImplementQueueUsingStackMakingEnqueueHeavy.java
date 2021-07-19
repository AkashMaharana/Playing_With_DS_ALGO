package com.akash.maharana.designAndImplementation;

import java.util.Stack;

//Making enQueue operation heavy

public class ImplementQueueUsingStackMakingEnqueueHeavy {
	
	public static void main(String[] args) {
		Queue q=new Queue();
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		q.enQueue(50);
		q.deQueue();
	}

}

class Queue{
	
	public static Stack<Integer> s1=new Stack<>();
	public static Stack<Integer> s2=new Stack<>();
	
	//O(N)
	public void enQueue(int data){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(data);
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}
	
	//O(1)
	public void deQueue(){
		if(s1.isEmpty()){
			System.out.println("Queue is empty");
		}
		else{
			int top=s1.peek();
			s1.pop();
			System.out.print(top+" ");
		}
	}
}
