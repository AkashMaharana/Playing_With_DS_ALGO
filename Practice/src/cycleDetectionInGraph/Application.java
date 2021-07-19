package cycleDetectionInGraph;

import java.util.List;
import java.util.ArrayList;

public class Application {
	
	public static void main(String[] args) {
		Vertex v1=new Vertex("1");
		Vertex v2=new Vertex("2");
		Vertex v3=new Vertex("5");
		Vertex v4=new Vertex("4");
		Vertex v5=new Vertex("8");
		Vertex v6=new Vertex("9");
		
		v1.addNeighbour(v2);
		v2.addNeighbour(v3);
		v2.addNeighbour(v4);
		v3.addNeighbour(v1);
		v4.addNeighbour(v5);
		v4.addNeighbour(v6);
		
		List<Vertex> vertexList=new ArrayList<>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v6);
		
		CycleDetection cyd=new CycleDetection();
		cyd.cycleDetection(vertexList);
	}

}
