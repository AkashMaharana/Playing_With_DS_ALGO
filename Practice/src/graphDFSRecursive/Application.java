package graphDFSRecursive;

import java.util.ArrayList;
import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		List<Vertex> l = new ArrayList<>();
		v1.addNeighbour(v2);
		v2.addNeighbour(v5);
		v2.addNeighbour(v3);
		v5.addNeighbour(v2);
		v4.addNeighbour(v1);
		v3.addNeighbour(v2);
		l.add(v1);
		l.add(v2);
		l.add(v3);
		l.add(v4);
		l.add(v5);
		DFSImpl dfs = new DFSImpl();
		dfs.dfs(l);
	}

}
