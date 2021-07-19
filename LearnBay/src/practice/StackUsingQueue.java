package practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<>();
		for(int i=0;i<10;i++){
			pushToTheQueue(q,i+1);
		}
		for(int i :q){
			System.out.print(i+" ");
		}
	}
	
	private static void pushToTheQueue(Queue<Integer> queue,int data){
		int queueSize=queue.size();
		if(queueSize==0){
			queue.add(data);
		}
		else{
			queue.add(data);
			for(int i=0;i<queueSize;i++){
				int dataDequed=queue.remove();
				queue.add(dataDequed);
			}
		}
	}

}
