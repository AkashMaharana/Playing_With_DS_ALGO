package bellManFord;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String data;
	private boolean isVisited;
	private List<Edge> edgeList;
	private Vertex predecessor;
	private double distance = Double.MAX_VALUE;
	
	public Vertex(String data){
		this.data=data;
		this.edgeList=new ArrayList<>();
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

	public List<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return this.data;
	}

	public void addEdge(Edge edge) {
		this.edgeList.add(edge);
	}

}
