package topologicalOrdering;

import java.util.Stack;

public class Topologicalordering {
	
	Stack<Vertex> vertexStack;
	
	public Topologicalordering(){
		this.vertexStack=new Stack<>();
	}
	
	public void dfs(Vertex vertex){
		 vertex.setVisited(true);
		 for(Vertex v : vertex.getNeighbourList()){
			 if(!v.isVisited()){
				 dfs(v);
			 }
		 }
		 vertexStack.push(vertex);
	}
	
	public Stack<Vertex> getStack(){
		return this.vertexStack;
	}

}
