package graphDFSIterative;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private int data;
	private List<Vertex> neighbourList;
	private boolean isVisited;

	public Vertex(int data) {
		this.data = data;
		this.neighbourList = new ArrayList<>();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
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

	@Override
	public String toString() {
		return this.data + "";
	}

	public void addNeighbour(Vertex vertex) {
		this.neighbourList.add(vertex);
	}

}
