package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class Graph {
	
	private int noOfVertex;
	private LinkedList<Integer>[] adjacenciesList;
	
	public Graph(int noOfVertex){
		this.noOfVertex=noOfVertex;
		adjacenciesList=new LinkedList[noOfVertex];
		for(int i=0;i<noOfVertex;i++){
			this.adjacenciesList[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int source,int destination){
		this.adjacenciesList[source].add(destination);
	}
	
	public void bfs(int source){
		boolean[] visitedArray=new boolean[this.noOfVertex];
		Queue<Integer> visitedQueue=new LinkedList<>();
		visitedArray[source]=true;
		visitedQueue.add(source);
		while(!visitedQueue.isEmpty()){
			Integer temp=visitedQueue.poll();
			System.out.print(temp+" ");
			Iterator<Integer> listIterator=this.adjacenciesList[temp].listIterator();
			while(listIterator.hasNext()){
				int tempvar=listIterator.next();
				if(visitedArray[tempvar]==false){
					visitedArray[tempvar]=true;
					visitedQueue.add(tempvar);
				}
			}
		}
	}

}
