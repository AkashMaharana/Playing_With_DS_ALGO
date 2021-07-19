package dfs;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	
	private Stack<Vertex> stack=new Stack<>();
	
	public void dfsIterative(List<Vertex> vertexList) {
		for(Vertex vertex : vertexList) {
			if(!vertex.isVisited()) {
				iterative(vertex);
			}
		}
	}
	
	private void iterative(Vertex vertex) {
		stack.add(vertex);
		vertex.setVisited(true);
		while(!stack.isEmpty()) {
			Vertex temp=stack.pop();
			System.out.println(temp);
			for(Vertex tempVertex : temp.getNeighbourList()) {
				if(!tempVertex.isVisited()) {
					stack.add(tempVertex);
					tempVertex.setVisited(true);
				}
			}
		}
	}
	
	public void dfsRecursive(List<Vertex> vertexList) {
		for(Vertex vertex : vertexList) {
			if(!vertex.isVisited()) {
				vertex.setVisited(true);
				recursive(vertex);
			}
		}
	}
	
	private void recursive(Vertex vertex) {
		System.out.println(vertex);
		for(Vertex temp : vertex.getNeighbourList()) {
			if(!temp.isVisited()) {
				temp.setVisited(true);
				recursive(temp);
			}
		}
	}

}
