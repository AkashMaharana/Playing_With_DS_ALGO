package cycleDetectionInGraph;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private List<Vertex> neighbourList;
	private boolean isVisited;
	private boolean isBeingVisited;

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

	public List<Vertex> getNeighbourList() {
		return neighbourList;
	}

	public void setNeighbourList(List<Vertex> neighbourList) {
		this.neighbourList = neighbourList;
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

	@Override
	public String toString() {
		return this.name;
	}

	public void addNeighbour(Vertex vertex) {
		this.neighbourList.add(vertex);
	}

}
