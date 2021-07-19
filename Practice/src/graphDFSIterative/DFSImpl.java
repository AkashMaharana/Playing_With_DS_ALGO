package graphDFSIterative;

import java.util.Stack;
import java.util.List;

public class DFSImpl {
	
	private Stack<Vertex> tempStack;
	
	public DFSImpl(){
		this.tempStack=new Stack<>();
	}
	
	public void dfs(List<Vertex> vertexList){
		for(Vertex v : vertexList){
			if(!v.isVisited()){
				v.setVisited(true);
				dfsIterative(v);
			}
		}
	}
	
	private void dfsIterative(Vertex vertex){
		tempStack.push(vertex);
		while(!tempStack.isEmpty()){
			Vertex v=tempStack.pop();
			System.out.print("Vertex : "+v+" : ");
			for(Vertex tempVertex : v.getNeighbourList()){
				if(!tempVertex.isVisited()){
					System.out.print(tempVertex+" ");
					tempVertex.setVisited(true);
					tempStack.push(tempVertex);
					
				}
			}
			System.out.println();
		}
	}

}
