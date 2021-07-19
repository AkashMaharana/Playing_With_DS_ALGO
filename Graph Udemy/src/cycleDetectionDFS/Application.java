package cycleDetectionDFS;

import java.util.List;
import java.util.ArrayList;

public class Application {
	
	public static void main(String[] args) {
		Vertex v1=new Vertex("1");
		Vertex v2=new Vertex("2");
		Vertex v3=new Vertex("3");
		Vertex v4=new Vertex("4");
		Vertex v5=new Vertex("5");
		Vertex v6=new Vertex("6");
		v1.addNeighbour(v2);
		v1.addNeighbour(v3);
		v2.addNeighbour(v3);
		v4.addNeighbour(v1);
		v4.addNeighbour(v5);
		v5.addNeighbour(v6);
		v6.addNeighbour(v4);
		List<Vertex> l=new ArrayList<>();
		l.add(v1);
		l.add(v2);
		l.add(v3);
		l.add(v4);
		l.add(v5);
		l.add(v6);
		
		CycleDetection cyd=new CycleDetection();
		cyd.detectCycle(l);
	}

}
