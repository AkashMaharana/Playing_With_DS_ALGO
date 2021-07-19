package bfs;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private int data;
	private boolean isVisited;
	private List<Vertex> neighbourList;

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

	@Override
	public String toString() {
		return this.data+"";
	}
	
	public void addVertex(Vertex vertex){
		this.neighbourList.add(vertex);
	}

}
