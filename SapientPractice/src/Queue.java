import java.util.Stack;

public class Queue {
	
	private Stack<Integer> temp=new Stack<>();
	
	public void enqueue(int data) {
		if(this.temp.isEmpty()) {
			temp.push(data);
		}
		else {
			enqueueData(temp,data);
		}
	}
	
	private void enqueueData(Stack<Integer> temp,int data) {
		int x=0;
		if(temp.isEmpty()) {
			temp.push(data);
			return;
		}
		else {
			x=temp.pop();
			enqueueData(temp,data);
		}
		temp.push(x);
		return;
	}
	
	public void dequeue() {
		if(!temp.isEmpty()) {
			System.out.println(temp.pop());
		}
	}

}
