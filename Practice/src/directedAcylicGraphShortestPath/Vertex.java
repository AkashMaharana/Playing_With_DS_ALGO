package directedAcylicGraphShortestPath;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private List<Edge> adjacenciesList;
	private boolean isVisited;
	private double distance = Double.MAX_VALUE;
	private Vertex predecessor;

	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void addEdge(Edge edge) {
		this.adjacenciesList.add(edge);
	}

}
