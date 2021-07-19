package bellManFordShortestPath;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private boolean isVisited;
	private double distance = Double.MAX_VALUE;
	private Vertex predecessor;
	private List<Edge> adjancenciesList;

	public Vertex(String name) {
		this.name = name;
		this.adjancenciesList = new ArrayList<>();
	}

	public void addNeighbour(Edge edge) {
		this.adjancenciesList.add(edge);
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

	public List<Edge> getAdjancenciesList() {
		return adjancenciesList;
	}

	public void setAdjancenciesList(List<Edge> adjancenciesList) {
		this.adjancenciesList = adjancenciesList;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
