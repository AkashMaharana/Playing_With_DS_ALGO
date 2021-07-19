package detectCycleInAnUndirectedGraphDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(new Vertex("0"));
		vertexList.add(new Vertex("1"));
		vertexList.add(new Vertex("2"));
		vertexList.add(new Vertex("3"));
		vertexList.add(new Vertex("4"));
		
		List<Edge> edgeList=new ArrayList<>();
		edgeList.add(new Edge(5,vertexList.get(0),vertexList.get(1)));
		edgeList.add(new Edge(10,vertexList.get(0),vertexList.get(2)));
		edgeList.add(new Edge(15,vertexList.get(1),vertexList.get(2)));
		edgeList.add(new Edge(1,vertexList.get(0),vertexList.get(3)));
		edgeList.add(new Edge(5,vertexList.get(3),vertexList.get(4)));
		
		DetectCycle dc=new DetectCycle();
		System.out.println(dc.detectCycle(vertexList, edgeList));
	}

}
