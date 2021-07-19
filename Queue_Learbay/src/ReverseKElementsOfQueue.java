import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsOfQueue {
	
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<>();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		reverseKElemets(q,3);
		for(int i:q){
			System.out.print(i+" ");
		}
	}
	
	public static void reverseKElemets(Queue<Integer> q,int k){
		Stack<Integer> s=new Stack<>();
		int noOfValueToBeReversed=k;
		while(k>0){
			s.push(q.remove());
			k=k-1;;
		}
		while(!s.isEmpty()){
			q.add(s.pop());
		}
		int reverseNo=q.size()-noOfValueToBeReversed;
		while(reverseNo>0){
			q.add(q.remove());
			reverseNo=reverseNo-1;
		}
	}

}
