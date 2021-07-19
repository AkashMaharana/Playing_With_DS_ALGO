package com.akash.maharana.queue;

public class Test {
	
	public static void main(String[] args) {
		CircularQueue cq=new CircularQueue(5);
		cq.enQueue(10);
		cq.enQueue(20);
		cq.enQueue(30);
		cq.enQueue(40);
		cq.enQueue(50);
		cq.deQueue();
		cq.enQueue(60);
		cq.deQueue();
		cq.deQueue();
		cq.enQueue(90);
		for(int i=0;i<cq.maxSize;i++){
			System.out.print(cq.arrayQueue[i]+" ");
		}
	}

}
