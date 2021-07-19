package dijkstraShortestPath;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DijkstraShortestPath {

	public void computePath(Vertex sourceVertex) {
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		sourceVertex.setDistance(0);
		queue.add(sourceVertex);
		
		while (!queue.isEmpty()) {
			Vertex actualVertex = queue.poll();
			for (Edge edge : actualVertex.getAdjaenciesList()) {
				Vertex tempVertex = edge.getEndVertex();
				double newDistance = actualVertex.getDistance() + edge.getWeight();
				if (newDistance < tempVertex.getDistance()) {
					queue.remove(tempVertex);
					tempVertex.setDistance(newDistance);
					tempVertex.setPredecessor(actualVertex);
					queue.add(tempVertex);
				}
			}
		}
	}

	public List<String> getShortestPath(Vertex targetVertex) {
		List<String> shortestPath = new ArrayList<>();
		for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
			shortestPath.add(vertex.getName());
		}
		Collections.reverse(shortestPath);
		return shortestPath;
	}

}
