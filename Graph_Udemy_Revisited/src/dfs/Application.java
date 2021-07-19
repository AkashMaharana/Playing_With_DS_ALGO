package dfs;

import java.util.ArrayList;
import java.util.List;

import dfs.Vertex;

public class Application {

	public static void main(String[] args) {
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");

		a.addNeighbour(b);
		a.addNeighbour(c);
		b.addNeighbour(d);
		c.addNeighbour(e);
		e.addNeighbour(f);
		f.addNeighbour(a);
		
		List<Vertex> list=new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		
		DepthFirstSearch dfs=new DepthFirstSearch();
		//dfs.dfsIterative(list);
		dfs.dfsRecursive(list);
	}

}
