package test;

import java.util.Collections;
import java.util.PriorityQueue;

public class Test {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		pq.add(1);
		pq.add(3);
		pq.add(-3);
		pq.add(4);
		pq.add(-4);
		pq.add(10);
		
		while(pq.size()>0) {
			System.out.println(pq.poll());
		}
	}

}
