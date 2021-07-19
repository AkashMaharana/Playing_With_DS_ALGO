package com.akash.maharana.designAndImplementation;

import java.util.Stack;

//Making Dequeue operation heavy

public class ImplementQueueUsingStackMakingDeQueueHeavy {
	
	public static void main(String[] args) {
		Queue1 q=new Queue1();
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		q.enQueue(50);
		q.deQueue();
		q.deQueue();
		q.deQueue();
	}

}

class Queue1{
	
	public static Stack<Integer> s1=new Stack<>();
	public static Stack<Integer> s2=new Stack<>();
	
	//O(1)
	public void enQueue(int data){
		s1.push(data);
	}
	
	//O(N)
	public void deQueue(){
		if(s1.isEmpty() && s2.isEmpty()){
			System.out.println("Queue is empty");
		}
		
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		System.out.print(s2.pop()+" ");
	}
}
