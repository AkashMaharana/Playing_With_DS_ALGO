package representationOfGraph;

import java.util.LinkedList;

public class AdjacenyListGraph {
	
	private int noOfVertex;
	private LinkedList<Integer>[] adjacenciesList;
	
	public AdjacenyListGraph(int noOfVertex){
		this.noOfVertex=noOfVertex;
		this.adjacenciesList=new LinkedList[noOfVertex]; 
		for(int i=0;i<adjacenciesList.length;i++){
			adjacenciesList[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(AdjacenyListGraph graph,int source,int destination){
		graph.adjacenciesList[source].add(destination);
		graph.adjacenciesList[destination].add(source);
	}
	
	public void printGraph(AdjacenyListGraph graph){
		for(int i=0;i<graph.noOfVertex;i++){
			System.out.print("Head - "+i+" : ");
			for(int j=0;j<graph.adjacenciesList[i].size();j++){
				System.out.print(graph.adjacenciesList[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	

}
