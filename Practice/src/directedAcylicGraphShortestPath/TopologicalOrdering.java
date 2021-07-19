package directedAcylicGraphShortestPath;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
	
	private Stack<Vertex> tempStack;
	
	public TopologicalOrdering(){
		this.tempStack=new Stack<>();
	}
	
	public void topologicalSort(List<Vertex> vertexList){
		for(Vertex vertex : vertexList){
			if(!vertex.isVisited()){
				dfs(vertex);
			}
		}
	}
	
	
	private void dfs(Vertex vertex){
		for(Edge edge : vertex.getAdjacenciesList()){
			if(!edge.getEndVertex().isVisited()){
				edge.getEndVertex().setVisited(true);
				dfs(edge.getEndVertex());
			}
		}
		tempStack.push(vertex);
	}
	
	public Stack<Vertex> getTopologicalOrder(){
		Collections.reverse(tempStack);
		return this.tempStack;
	}

}
