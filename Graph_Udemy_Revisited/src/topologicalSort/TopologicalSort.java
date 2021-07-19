package topologicalSort;

import java.util.Stack;

public class TopologicalSort {
	
	private Stack<Vertex> stack=new Stack<>();
	
	public void sort(Vertex vertex) {
		vertex.setVisited(true);
		for(Vertex temp : vertex.getNeighbourList()) {
			if(!temp.isVisited()) {
				sort(temp);
			}
		}
		stack.push(vertex);
	}
	
	public Stack<Vertex> getStack(){
		return this.stack;
	}

}
