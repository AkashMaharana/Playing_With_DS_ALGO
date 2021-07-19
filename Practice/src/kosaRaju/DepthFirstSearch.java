package kosaRaju;

import java.util.Stack;

public class DepthFirstSearch {
	
	private Stack<Vertex> tempStack;
	
	public DepthFirstSearch(Graph graph){
		this.tempStack=new Stack<>();
		for(Vertex vertex : graph.getVertexList()){
			if(!vertex.isVisited()){
				dfs(vertex);
			}
		}
	}
	
	private void dfs(Vertex vertex){
		vertex.setVisited(true);
		for(Vertex v : vertex.getAdjacenciesList()){
			if(!v.isVisited()){
				dfs(v);
			}
		}
		tempStack.push(vertex);
	}
	
	public Stack<Vertex> getReversePost(){
		return this.tempStack;
	}

}
