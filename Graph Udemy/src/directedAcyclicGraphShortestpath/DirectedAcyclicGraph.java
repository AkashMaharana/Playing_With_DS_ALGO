package directedAcyclicGraphShortestpath;

import java.util.List;
import java.util.Stack;

public class DirectedAcyclicGraph {
	
	public void shortestPath(List<Vertex> vertices,Vertex sourceVertex,Vertex targetVertex){
		sourceVertex.setMinimumDistance(0);
		TopologicalSort topologicalSort=new TopologicalSort();
		topologicalSort.makeTopologicalOrder(vertices);
		Stack<Vertex> topologicalReverseOrderStack=topologicalSort.getTopologicalOrder();
		for(Vertex v : topologicalReverseOrderStack){
			System.out.print(v.getName()+" ");
			for(Edge edge : v.getAdjacenciesList()){
				Vertex start=edge.getStartVertex();
				Vertex end=edge.getEndVertex();
				double newDistance=start.getMinimumDistance()+edge.getWeight();
				if(newDistance<end.getMinimumDistance()){
					end.setMinimumDistance(newDistance);
					end.setPredecessor(start);	
				}
			}
		}
		System.out.println();
		if(targetVertex.getMinimumDistance()==Double.MAX_VALUE){
			System.out.println("No shortest path is present.");
		}
		else{
			System.out.println("Target vertex shortest path : "+targetVertex.getMinimumDistance());
		}
	}

}
