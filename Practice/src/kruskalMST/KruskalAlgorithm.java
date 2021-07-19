package kruskalMST;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
	
	public void kruskalAlgorithm(List<Vertex> vertexList,List<Edge> edgeList){
		DisjointSet djs=new DisjointSet(vertexList);
		List<Edge> mst=new ArrayList<>();
		Collections.sort(edgeList);
		for(Edge edge : edgeList){
			Vertex startVertex=edge.getStartVertex();
			Vertex endVertex=edge.getEndVertex();
			if(djs.find(startVertex.getNode())!=djs.find(endVertex.getNode())){
				mst.add(edge);
				djs.union(startVertex.getNode(),endVertex.getNode());
			}
		}
		for(Edge edge : mst){
			System.out.print(edge.getStartVertex()+""+edge.getEndVertex()+"-");
		}
	}

}
