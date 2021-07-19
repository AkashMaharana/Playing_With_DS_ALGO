package heap;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
	
	public static void main(String[] args) {
		int[] arr= {4,2,7,6,9};
		System.out.println("Minimum cost for connecting the ropes : "+calculateMinimumCost(arr));
	}
	
	private static int calculateMinimumCost(int[] arr) {
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			queue.add(arr[i]);
		}
		int minimumCost=0;
		while(queue.size()>1) {
			int temp1=queue.poll();
			int temp2=queue.poll();
			queue.add(temp1+temp2);
			minimumCost=minimumCost+(temp1+temp2);
		}
		return minimumCost;
	}

}
