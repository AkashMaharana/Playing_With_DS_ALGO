package dfs;

import java.util.List;
import java.util.ArrayList;

public class Application {
	
	public static void main(String[] args) {
		Vertex v1=new Vertex("1");
		Vertex v2=new Vertex("2");
		Vertex v3=new Vertex("3");
		Vertex v4=new Vertex("4");
		Vertex v5=new Vertex("5");
		List<Vertex> l=new ArrayList<>();
		v1.addToNeighbour(v2);
		v2.addToNeighbour(v5);
		v2.addToNeighbour(v3);
		v5.addToNeighbour(v2);
		v4.addToNeighbour(v1);
		v3.addToNeighbour(v2);
		l.add(v1);
		l.add(v2);
		l.add(v3);
		l.add(v4);
		l.add(v5);
		DFS dfs=new DFS();
		dfs.dfs(l);
	}

}
