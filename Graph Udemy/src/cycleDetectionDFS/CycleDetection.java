package cycleDetectionDFS;

import java.util.List;

public class CycleDetection {
	
	public void detectCycle(List<Vertex> vertexList){
		for(Vertex v : vertexList){
			if(!v.isVisited()){
				dfs(v);
			}
		}
	}
	
	public void dfs(Vertex vertex){
		System.out.println("DFS on Vertex "+vertex);
		vertex.setBeingVisited(true);
		for(Vertex v : vertex.getAdjacencyList()){
			System.out.println("Visiting the neighbour of vertex : "+vertex);
			if(v.isBeingVisited()){
				System.out.println("There is a backward edge. Cycle found");
				return;
			}
			if(!v.isVisited()){
				System.out.println("Visiting vertex "+v+" recursively.");
				v.setVisited(true);
				dfs(v);
			}
		}
		System.out.println("Set Vertex "+vertex+" set beingVisited(falase) & visited(true).");
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}

}
