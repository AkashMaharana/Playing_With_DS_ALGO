package depthFirstSearch;

import java.util.LinkedList;
import java.util.Iterator;

public class Graph {
	
	private int noOfVertex;
	private LinkedList<Integer>[] adjacenciesList;
	private boolean[] visitedArray;
	
	public Graph(int noOfVertex){
		this.noOfVertex=noOfVertex;
		adjacenciesList=new LinkedList[this.noOfVertex];
		for(int i=0;i<noOfVertex;i++){
			this.adjacenciesList[i]=new LinkedList<>();
		}
		this.visitedArray=new boolean[this.noOfVertex];
	}
	
	public void addEdge(int source,int destination){
		this.adjacenciesList[source].add(destination);
	}
	
	public void dfs(int source){
		System.out.print(source+" ");
		visitedArray[source]=true;
		Iterator<Integer> listIterator=this.adjacenciesList[source].listIterator();
		while(listIterator.hasNext()){
			Integer temp=listIterator.next();
			if(visitedArray[temp]==false){
				dfs(temp);
			}
		}
	}

}
