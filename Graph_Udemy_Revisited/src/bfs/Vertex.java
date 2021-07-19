package bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private boolean isVisited;
	private List<Vertex> neighbourList;

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

	public void addNeighbour(Vertex vertex) {
		this.neighbourList.add(vertex);
	}

	public List<Vertex> getNeighbourList() {
		return neighbourList;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	

}
