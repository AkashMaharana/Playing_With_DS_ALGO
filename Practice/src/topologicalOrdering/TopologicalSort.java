package topologicalOrdering;

import java.util.Stack;

public class TopologicalSort {
	
	private Stack<String> tempStack=new Stack<>();
	
	public void topologicalSort(Vertex vertex){
		vertex.setVisited(true);
		for(Vertex v : vertex.getNeighbourList()){
			if(!v.isVisited()){
				topologicalSort(v);
			}
		}
		tempStack.push(vertex.getName());
	}
	
	public Stack<String> getStack(){
		return this.tempStack;
	}

}
