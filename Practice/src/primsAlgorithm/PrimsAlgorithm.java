package primsAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
	
	private List<Vertex> unVisitedVertex;
	private List<Edge> spanningTree;
	private PriorityQueue<Edge> edgeHeap;
	private double fullCost;

	public PrimsAlgorithm(List<Vertex> unVisitedVertex){
		this.unVisitedVertex=unVisitedVertex;
		this.edgeHeap=new PriorityQueue<>();
		this.spanningTree=new ArrayList<>();
	}
	
	public void primsAlgorithm(Vertex vertex){
		unVisitedVertex.remove(vertex);
		while(!unVisitedVertex.isEmpty()){
			for(Edge edge : vertex.getAdjancenciesList()){
				if(unVisitedVertex.contains(edge.getEndVertex())){
					edgeHeap.add(edge);
				}
			}
			Edge tempEdge=edgeHeap.poll();
			spanningTree.add(tempEdge);
			fullCost=fullCost+tempEdge.getWeight();
			Vertex tempVertex=tempEdge.getEndVertex();
			unVisitedVertex.remove(tempVertex);
		}
		for(Edge edge : spanningTree){
			System.out.print(edge.getStartVertex()+""+edge.getEndVertex()+"-");
		}
		System.out.println();
		System.out.println("Full Cost : "+fullCost);
	}
	
	public List<Edge> getSpanningTree() {
		return this.spanningTree;
	}
	
	public void clearData() {
		this.spanningTree.clear();
		this.edgeHeap.clear();
	}
}
