
public class Test1 {
	
	public static void main(String[] args) {
		System.out.println("//Implement queue using stack");
		Queue q=new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		
		System.out.println("//Implement Stack using queue");
		Stack stack=new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
	}

}
