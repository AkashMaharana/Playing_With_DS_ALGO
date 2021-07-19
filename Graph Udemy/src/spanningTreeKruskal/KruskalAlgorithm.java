package spanningTreeKruskal;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
	
	public void spanningTree(List<Vertex> vertexList, List<Edge> edgeList){
		DisjointSet disjointSet=new DisjointSet(vertexList);
		List<Edge> mst=new ArrayList<>();
		Collections.sort(edgeList);
		for(Edge edge : edgeList){
			Vertex start=edge.getStartVertex();
			Vertex end=edge.getEndVertex();
			if(disjointSet.find(start.getNode())!=disjointSet.find(end.getNode())){
				mst.add(edge);
				disjointSet.union(start.getNode(), end.getNode());
			}
		}
		for(Edge edge : mst){
			System.out.print(edge.getStartVertex()+""+edge.getEndVertex()+"-");
		}
	}

}
