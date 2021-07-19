package primsAlgorithm;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private Vertex predecessor;
	private boolean isVisited;
	private List<Edge> adjancenciesList;

	public Vertex(String name) {
		this.name = name;
		this.adjancenciesList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
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

	public void addEdge(Edge edge) {
		this.adjancenciesList.add(edge);
	}

}
