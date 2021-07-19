package dijkstraShortestPath;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DijkstraShortestPath {
	
	public void computePath(Vertex sourceVertex){
		PriorityQueue<Vertex> priorityQueue=new PriorityQueue<>();
		sourceVertex.setDistance(0);
		priorityQueue.add(sourceVertex);
		
		while(!priorityQueue.isEmpty()){
			Vertex actualVertex=priorityQueue.poll();
			for(Edge edge : actualVertex.getAdjacenciesList()){
				Vertex tempVertex=edge.getTargetVertex();
				double newDistance=actualVertex.getDistance()+edge.getWeight();
				if(newDistance<tempVertex.getDistance()){
					priorityQueue.remove(tempVertex);
					tempVertex.setDistance(newDistance);
					tempVertex.setPredecessor(actualVertex);
					priorityQueue.add(tempVertex);
				}
			}
		}
	}
	
	public List<Vertex> getShortestPath(Vertex targetVertex){
		List<Vertex> shortestPath=new ArrayList<>();
		for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
			shortestPath.add(vertex);
		}
		Collections.reverse(shortestPath);
		return shortestPath;
	}

}
