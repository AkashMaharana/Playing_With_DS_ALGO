package cycleDetectionDFS;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private boolean isVisited;
	private boolean isBeingVisited;
	private List<Vertex> adjacencyList;

	public Vertex(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean isBeingVisited() {
		return isBeingVisited;
	}

	public void setBeingVisited(boolean isBeingVisited) {
		this.isBeingVisited = isBeingVisited;
	}

	public List<Vertex> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<Vertex> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public void addNeighbour(Vertex vertex) {
		this.adjacencyList.add(vertex);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
