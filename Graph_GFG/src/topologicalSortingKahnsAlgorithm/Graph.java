package topologicalSortingKahnsAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Graph {
	
	private int noOfVertex;
	private LinkedList<Integer>[] adjacenciesList;
	
	public Graph(int noOfVertex){
		this.noOfVertex=noOfVertex;
		this.adjacenciesList=new LinkedList[this.noOfVertex];
		for(int i=0;i<this.noOfVertex;i++){
			this.adjacenciesList[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int source,int destination){
		this.adjacenciesList[source].add(destination);
	}
	
	public void topologicalSort(){
		int[] indegreeArray=new int[this.noOfVertex];
		for(int i=0;i<this.noOfVertex;i++){
			for(int tempvalue : this.adjacenciesList[i]){
				indegreeArray[tempvalue]=indegreeArray[tempvalue]+1;
			}
		}
		Queue<Integer> indegreeQueue=new LinkedList<>();
		for(int i=0;i<indegreeArray.length;i++){
			if(indegreeArray[i]==0){
				indegreeQueue.add(i);
			}
		}
		int count=0;
		Vector<Integer> result=new Vector<>();
		while(!indegreeQueue.isEmpty()){
			int temp=indegreeQueue.poll();
			result.add(temp);
			for(int temp1 : this.adjacenciesList[temp]){
				indegreeArray[temp1]=indegreeArray[temp1]-1;
				if(indegreeArray[temp1]==0){
					indegreeQueue.add(temp1);
				}
			}
			count=count+1;
		}
		if(count!=this.noOfVertex){
			System.out.println("There exists a cycle in the graph");
			return;
		}
		for(Integer i : result){
			System.out.print(i+" ");
		}
	}

}
