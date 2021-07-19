import java.util.LinkedList;
import java.util.Queue;

public class Stack {

	private Queue<Integer> queue=new LinkedList<>();
	
	public void push(int data) {
		if(queue.isEmpty()) {
			this.queue.add(data);
		}
		else {
			pushData(queue,data);
		}
	}
	
	private void pushData(Queue<Integer> queue,int data) {
		int x=0;
		if(queue.isEmpty()) {
			queue.add(data);
			return;
		}
		else {
			x=queue.remove();
			pushData(queue,data);
		}
		queue.add(x);
		return;
	}
	
	public void pop() {
		if(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
	}
}
