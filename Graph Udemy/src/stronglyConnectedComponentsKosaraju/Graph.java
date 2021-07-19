package stronglyConnectedComponentsKosaraju;

import java.util.List;
import java.util.ArrayList;

public class Graph {

	private List<Vertex> vertexList;
	private List<Edge> edgeList;

	public Graph() {

	}

	public Graph(List<Vertex> vertexList, List<Edge> edgeList) {
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}
	
	public Graph transposeGraph(){
		Graph transposeGraph=new Graph();
		List<Vertex> transposeVertexList=new ArrayList<>();
		for(Vertex vertex : this.vertexList){
			transposeVertexList.add(vertex);
		}
		for(Edge edge : this.edgeList){
			transposeVertexList.get(transposeVertexList.indexOf(edge.getEndVertex())).addNeighbour(edge.getStartVertex());
		}
		transposeGraph.setVertexList(transposeVertexList);
		return transposeGraph;
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}

}
