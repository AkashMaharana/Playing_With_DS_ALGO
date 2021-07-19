package com.akash.maharana.designAndImplementation;

import java.util.Stack;

public class ImplementQueueUsingOneStackRecursively {
	
	public static void main(String[] args) {
		
		Queue2 q=new Queue2();
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		System.out.print(q.deQueue(q)+" ");
		System.out.print(q.deQueue(q)+" ");
	}

}

class Queue2{
	public Stack<Integer> s1=new Stack<>();
	
	public void enQueue(int data){
		s1.push(data);
	}
	
	public int deQueue(Queue2 q){
		int x;
		int result=0;
		if(q.s1.isEmpty()){
			System.out.println("Queue is empty");
		}
		else if(q.s1.size()==1){
			return q.s1.pop();
		}
		else{
			x=q.s1.pop();
			result=deQueue(q);
			q.s1.push(x);
			return result;
		}
		return 0;
	}
}
