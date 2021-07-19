package cycleDetectionInGraph;

import java.util.List;

public class CycleDetection {
	
	public void cycleDetection(List<Vertex> vertexList){
		for(Vertex vertex : vertexList){
			if(!vertex.isBeingVisited()){
				dfs(vertex);
			}
		}
	}
	
	private void dfs(Vertex vertex){
		vertex.setBeingVisited(true);
		for(Vertex v : vertex.getNeighbourList()){
			if(v.isBeingVisited()){
				System.out.println("Cycle detected");
				return;
			}
			if(!v.isVisited()){
				v.setVisited(true);
				dfs(v);
			}
			
		}
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}

}