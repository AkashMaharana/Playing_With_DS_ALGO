import java.util.LinkedList;
import java.util.Queue;

public class QueueRearrangement {
	
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<>();
		for(int i=0;i<10;i++){
			q.add(i+1);
		}
		rearrange(q);
		for(int i : q){
			System.out.print(i+" ");
		}
	}
	
	private static void rearrange(Queue<Integer> q){
		Queue<Integer> tempQueue=new LinkedList<>();
		int size=q.size()/2;
		while(size>0){
			tempQueue.add(q.remove());
			size--;
		}
		while(!tempQueue.isEmpty()){
			q.add(tempQueue.remove());
			q.add(q.remove());
		}
	}

}
