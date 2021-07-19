package directedAcyclicGraphShortestpath;

import java.util.Stack;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {
	
	private Stack<Vertex> stack;
	
	public TopologicalSort(){
		stack=new Stack<>();
	}
	
	public void makeTopologicalOrder(List<Vertex> vertexList){
		for(Vertex v : vertexList){
			if(!v.isIdentified()){
				dfs(v);
			}
		}
	}
	
	private void dfs(Vertex vertex){
		for(Edge edge : vertex.getAdjacenciesList()){
			if(!edge.getEndVertex().isIdentified()){
				edge.getEndVertex().setIdentified(true);
				dfs(edge.getEndVertex());
			}
		}
		stack.push(vertex);
	}
	
	public Stack<Vertex> getTopologicalOrder(){
		Collections.reverse(stack);
		return this.stack;
	}

}
