package cycleDetection;

import java.util.ArrayList;
import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		Vertex v0=new Vertex("0");
		Vertex v1=new Vertex("1");
		Vertex v2=new Vertex("2");
		Vertex v3=new Vertex("3");
		
		v0.addNeighbour(v1);
		v1.addNeighbour(v2);
		v2.addNeighbour(v3);
		v3.addNeighbour(v0);
		
		List<Vertex> vertexList=new ArrayList<>();
		vertexList.add(v0);
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		
		CycleDetection cycle=new CycleDetection();
		cycle.detectCycle(vertexList);
	}

}
