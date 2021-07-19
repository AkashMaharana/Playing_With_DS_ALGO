package topologicalOrdering;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Application {
	
	public static void main(String[] args) {
		List<Vertex> graph1=new ArrayList<>();
		graph1.add(new Vertex("A"));
		graph1.add(new Vertex("B"));
		graph1.add(new Vertex("C"));
		graph1.add(new Vertex("D"));
		graph1.add(new Vertex("E"));
		graph1.get(0).addNeighbour(graph1.get(1));
		graph1.get(0).addNeighbour(graph1.get(2));
		graph1.get(1).addNeighbour(graph1.get(3));
		graph1.get(2).addNeighbour(graph1.get(3));
		graph1.get(2).addNeighbour(graph1.get(4));
		graph1.get(3).addNeighbour(graph1.get(4));
		Topologicalordering tpo=new Topologicalordering();
		for(int i=0;i<graph1.size();i++){
			if(!graph1.get(i).isVisited()){
				tpo.dfs(graph1.get(i));
			}
		}
		Stack<Vertex> s=tpo.getStack();
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
	}

}
