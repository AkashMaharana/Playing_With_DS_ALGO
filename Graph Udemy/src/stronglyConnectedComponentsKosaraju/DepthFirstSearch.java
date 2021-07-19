package stronglyConnectedComponentsKosaraju;

import java.util.Stack;

public class DepthFirstSearch {
	
	private Stack<Vertex> stack;
	
	public DepthFirstSearch(Graph graph){
		stack=new Stack<>();
		for(Vertex vertex : graph.getVertexList()){
			if(!vertex.isIdentified()){
				dfs(vertex);
			}
		}
	}
	
	private void dfs(Vertex vertex){
		vertex.setIdentified(true);
		for(Vertex v : vertex.getAdjacenciesList()){
			if(!v.isIdentified()){
				dfs(v);
			}
		}
		stack.push(vertex);
	}
	
	public Stack<Vertex> getReversePost(){
		return this.stack;
	}

}
