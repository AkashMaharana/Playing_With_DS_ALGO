public class CircularQueue {
	
	int maxSize;
	int rear;
	int front;
	int[] arrayQueue;
	int currentSize;
	
	public CircularQueue(int maxSize){
		this.maxSize=maxSize;
		this.front=0;
		this.rear=0;
		this.arrayQueue=new int[this.maxSize];
		this.currentSize=0;
	}
	
	public void enQueue(int data){
		if(isFull()){
			System.out.println("Circular Queue is full");
		}
		else{
			this.arrayQueue[this.rear]=data;
			this.rear=(this.rear+1)%this.maxSize;
			this.currentSize=this.currentSize+1;
		}
	}
	
	public boolean isFull(){
		if(this.currentSize==maxSize){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void deQueue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
		else{
			this.arrayQueue[this.front]=0;
			this.front=(this.front+1)%this.maxSize;
			this.currentSize=this.currentSize-1;
		}
	}
	
	public boolean isEmpty(){
		if(this.currentSize==0){
			return true;
		}
		else{
			return false;
		}
	}

}
