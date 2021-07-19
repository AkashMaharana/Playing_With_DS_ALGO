package graphBFS;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private int data;
	private List<Vertex> neighourList;
	private boolean isVisited;

	public Vertex(int data) {
		this.data = data;
		this.neighourList = new ArrayList<>();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List<Vertex> getNeighourList() {
		return neighourList;
	}

	public void setNeighourList(List<Vertex> neighourList) {
		this.neighourList = neighourList;
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
		this.neighourList.add(vertex);
	}

}
