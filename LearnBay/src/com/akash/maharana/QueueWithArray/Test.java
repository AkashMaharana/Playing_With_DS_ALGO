package com.akash.maharana.QueueWithArray;

public class Test {
	
	public static void main(String[] args) {
		Queue q=new Queue(10);
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(20);
		q.enQueue(15);
		System.out.println(q.size());
		/*q.deQueue();
		q.deQueue();
		System.out.println(q.size());
		q.deQueue();*/
	}

}
