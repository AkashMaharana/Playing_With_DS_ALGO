package com.akash.maharana.QueueWithArray;

public class Queue {
	int front;
	int rear;
	int[] queue;
	
	public Queue(int capacity){
		this.front=0;
		this.rear=-1;
		this.queue=new int[capacity];
	}
	
	public void enQueue(int data){
		if(this.queue.length==this.rear){
			System.out.println("Queue is full");
		}
		else{
			this.queue[this.rear++]=data;
		}
	}
	
	public int size(){
		return this.rear+1;
	}
	
	public void deQueue(){
		if(this.front==this.rear+1){
			System.out.println("Queue is Empty");
		}
		else{
			for(int i=0;i<=this.rear;i++){
				this.queue[i]=this.queue[i+1];
			}
			this.rear--;
		}
	}
	
}
