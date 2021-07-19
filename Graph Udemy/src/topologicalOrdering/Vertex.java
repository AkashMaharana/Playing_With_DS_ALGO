package topologicalOrdering;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String data;
	private boolean isVisited;
	private List<Vertex> neighbourList;

	public Vertex(String data) {
		this.data = data;
		this.neighbourList = new ArrayList<>();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public void setNeighbourList(List<Vertex> neighbourList) {
		this.neighbourList = neighbourList;
	}
	
	public void addNeighbour(Vertex vertex){
		this.neighbourList.add(vertex);
	}

	@Override
	public String toString() {
		return this.data;
	}

}
