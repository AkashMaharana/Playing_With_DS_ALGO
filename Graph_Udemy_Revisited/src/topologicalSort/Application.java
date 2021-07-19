package topologicalSort;

import java.util.Stack;

public class Application {
	
	public static void main(String[] args) {
		Vertex v0=new Vertex("0");
		Vertex v1=new Vertex("1");
		Vertex v2=new Vertex("2");
		Vertex v3=new Vertex("3");
		Vertex v4=new Vertex("4");
		Vertex v5=new Vertex("5");
		Vertex v6=new Vertex("6");
		Vertex v7=new Vertex("7");
		
		v7.addNeighbour(v5);
		v7.addNeighbour(v6);
		
		v5.addNeighbour(v2);
		v5.addNeighbour(v4);
		
		v6.addNeighbour(v4);
		v6.addNeighbour(v3);
		
		v2.addNeighbour(v1);
		v3.addNeighbour(v1);
		
		v1.addNeighbour(v0);
		
		TopologicalSort topologicalSort=new TopologicalSort();
		topologicalSort.sort(v7);
		Stack<Vertex> stack=topologicalSort.getStack();
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
