package graphDFSRecursive;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private int data;
	private List<Vertex> vertexList;
	private boolean isVisited;

	public Vertex(int data) {
		this.data = data;
		this.vertexList = new ArrayList<>();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
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

	public void addNeighbour(Vertex vertex){
		this.vertexList.add(vertex);
	}

}
