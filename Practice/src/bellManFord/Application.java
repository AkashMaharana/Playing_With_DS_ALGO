package bellManFord;

import java.util.List;
import java.util.ArrayList;

public class Application {
	
	public static void main(String[] args) {
		List<Vertex> vertexList=new ArrayList<>();
		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));
		
		List<Edge> edgeList=new ArrayList<>();
		edgeList.add(new Edge(1,vertexList.get(0),vertexList.get(1)));
		edgeList.add(new Edge(10,vertexList.get(0),vertexList.get(2)));
		edgeList.add(new Edge(1,vertexList.get(1),vertexList.get(2)));
		
		BellManFord blf=new BellManFord(vertexList, edgeList);
		blf.bellManFord(vertexList.get(0));
		blf.getShortestPath(vertexList.get(2));
	}

}
