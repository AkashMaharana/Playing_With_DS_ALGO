package dfs;

import java.util.Stack;
import java.util.List;

public class DFS {
	
	private Stack<Vertex> tempStack;
	
	public DFS(){
		this.tempStack=new Stack<>();
	}
	
	public void dfs(List<Vertex> vertexList){
		for(Vertex v : vertexList){
			if(!v.isVisited()){
				v.setVisited(true);
				dfsWithStack(v);
				//dfsRecursive(v);
			}
		}
	}
	
	private void dfsRecursive(Vertex vertex){
		System.out.print(vertex.getName()+" ");
		for(Vertex v  : vertex.getNeighbourList()){
			if(!v.isVisited()){
				v.setVisited(true);
				dfsRecursive(v);
			}
		}
	}
	
	private void dfsWithStack(Vertex vertex){
		this.tempStack.push(vertex);
		vertex.setVisited(true);
		while(!tempStack.isEmpty()){
			Vertex tempvertex=tempStack.pop();
			System.out.print(tempvertex.getName()+" : ");
			for(Vertex v : tempvertex.getNeighbourList()){
				System.out.println(v.getName()+" ");
				if(!v.isVisited()){
					v.setVisited(true);
					this.tempStack.push(v);
				}
			}
		}
	}

}
