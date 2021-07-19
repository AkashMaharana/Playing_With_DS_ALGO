package spanningTreePrimsLazy;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class PrimsAlgorithm {
	
	private List<Vertex> unvisitedVertex;
	private List<Edge> spanningTree;
	private PriorityQueue<Edge> edgeHeap;
	private double fullCost;
	
	public PrimsAlgorithm(List<Vertex> unvisitedVertex){
		this.unvisitedVertex=unvisitedVertex;
		this.spanningTree=new ArrayList<>();
		this.edgeHeap=new PriorityQueue<>();
	}
	
	public void primsAlgorithm(Vertex vertex){
		unvisitedVertex.remove(vertex);
		while(!unvisitedVertex.isEmpty()){
			for(Edge edge : vertex.getAdjacenciesList()){
				if(unvisitedVertex.contains(edge.getEndVertex())){
					this.edgeHeap.add(edge); 
				}
			}
			Edge tempEdge=edgeHeap.poll();
			this.spanningTree.add(tempEdge);
			this.fullCost=this.fullCost+tempEdge.getWeight();
			Vertex tempVertex=tempEdge.getEndVertex();
			unvisitedVertex.remove(tempVertex);
		}
		for(Edge edge : spanningTree){
			System.out.print(edge.getStartVertex()+""+edge.getEndVertex()+"-");
		}	
		System.out.println();
		System.out.println("Full Cost : "+fullCost);
	}
	
	public void setUnvisitedVertices(List<Vertex> unvisitedVertex) {
		this.unvisitedVertex = unvisitedVertex;
	}

	public List<Edge> getSpanningTree() {
		return this.spanningTree;
	}

	public void clearData() {
		this.spanningTree.clear();
		this.edgeHeap.clear();
	}

}
