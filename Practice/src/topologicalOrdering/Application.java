package topologicalOrdering;

import java.util.Stack;

public class Application {
	
	public static void main(String[] args) {
		Vertex v1=new Vertex("A");
		Vertex v2=new Vertex("B");
		Vertex v3=new Vertex("C");
		Vertex v4=new Vertex("D");
		Vertex v5=new Vertex("E");
		v1.addNeighbour(v2);
		v1.addNeighbour(v3);
		v2.addNeighbour(v4);
		v3.addNeighbour(v4);
		v3.addNeighbour(v5);
		v4.addNeighbour(v5);
		TopologicalSort tpo=new TopologicalSort();
		tpo.topologicalSort(v1);
		Stack<String> s=tpo.getStack();
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
	}

}
