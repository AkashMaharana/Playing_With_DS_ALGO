package graphDFSRecursive;

import java.util.List;

public class DFSImpl {
	
	public void dfs(List<Vertex> vertexList){
		for(Vertex vertex : vertexList){
			if(!vertex.isVisited()){
				vertex.setVisited(true);
				dfsRecursive(vertex);
			}
		}
	}
	
	private void dfsRecursive(Vertex vertex){
		System.out.print(vertex+" ");
		for(Vertex v : vertex.getVertexList()){
			if(!v.isVisited()){
				v.setVisited(true);
				dfsRecursive(v);
			}
		}
	}

}
