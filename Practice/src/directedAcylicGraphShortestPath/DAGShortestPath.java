package directedAcylicGraphShortestPath;

import java.util.Stack;

import java.util.List;

public class DAGShortestPath {
	
	public void getShortestPath(List<Vertex> vertexList,Vertex sourceVertex,Vertex targetVertex){
		sourceVertex.setDistance(0);
		TopologicalOrdering tpo=new TopologicalOrdering();
		tpo.topologicalSort(vertexList);
		Stack<Vertex> topologicalSortList=tpo.getTopologicalOrder();
		for(Vertex vertex : topologicalSortList){
			System.out.print(vertex+" ");
			for(Edge edge : vertex.getAdjacenciesList()){
				Vertex startVertex=edge.getStartVertex();
				Vertex endVertex=edge.getEndVertex();
				double newDistance=edge.getWeight()+startVertex.getDistance();
				if(newDistance<endVertex.getDistance()){
					endVertex.setDistance(newDistance);
					endVertex.setPredecessor(startVertex);
				}
			}
		}
		System.out.println();
		if(targetVertex.getDistance()==Double.MAX_VALUE){
			System.out.println("No shortest path exists.");
		}
		else{
			System.out.println("Shortest path distance : "+targetVertex.getDistance());
		}
	}

}
