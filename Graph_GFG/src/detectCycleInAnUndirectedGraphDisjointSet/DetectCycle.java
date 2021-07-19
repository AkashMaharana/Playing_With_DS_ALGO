package detectCycleInAnUndirectedGraphDisjointSet;

import java.util.List;

public class DetectCycle {
	
	public boolean detectCycle(List<Vertex> vertexList,List<Edge> edgeList){
		DisjointSet djs=new DisjointSet(vertexList);
		for(Edge edge : edgeList){
			if(djs.find(edge.getStartVertex().getNode())==djs.find(edge.getEndVertex().getNode())){
				return true;
			}
			djs.union(edge.getStartVertex().getNode(), edge.getEndVertex().getNode());
		}
		return false;
	}

}
