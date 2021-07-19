package topologicalSort;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private List<Vertex> neighbourList;
	private boolean isVisited;

	public Vertex(String name) {
		this.name = name;
		this.neighbourList = new ArrayList<>();
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

	public List<Vertex> getNeighbourList() {
		return neighbourList;
	}

	public void addNeighbour(Vertex vertex) {
		this.neighbourList.add(vertex);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
