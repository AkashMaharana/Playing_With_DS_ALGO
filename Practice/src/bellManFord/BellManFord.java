package bellManFord;

import java.util.List;

public class BellManFord {
	
	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	
	public BellManFord(List<Vertex> vertexList, List<Edge> edgeList){
		this.vertexList=vertexList;
		this.edgeList=edgeList;
	}
	
	public void bellManFord(Vertex sourceVertex){
		sourceVertex.setDistance(0);
		for(int i=0;i<vertexList.size()-1;i++){
			for(Edge edge : edgeList){
				Vertex startVertex=edge.getStartVertex();
				Vertex endVertex=edge.getEndVertex();
				if(startVertex.getDistance()==Double.MAX_VALUE){
					continue;
				}
				double newDistance=startVertex.getDistance()+edge.getWeight();
				if(newDistance<endVertex.getDistance()){
					endVertex.setDistance(newDistance);
					endVertex.setPredecessor(startVertex);
				}
			}
		}
		for(Edge edge : edgeList){
			if(edge.getStartVertex().getDistance()!=Double.MAX_VALUE){
				if(hasCycle(edge)){
					System.out.println("Cycle Detected.");
					return;
				}
			}
		}
	}
	
	public boolean hasCycle(Edge edge){
		return edge.getWeight()+edge.getStartVertex().getDistance()<edge.getEndVertex().getDistance();
	}
	
	public void getShortestPath(Vertex targetVertex){
		if(targetVertex.getDistance()!=Double.MAX_VALUE){
			System.out.println("There is a shortest path from source to target having cost : "+targetVertex.getDistance());
			Vertex actualVertex=targetVertex;
			System.out.print(actualVertex+" ");
			while(actualVertex.getPredecessor()!=null){
				actualVertex=actualVertex.getPredecessor();
				System.out.print(actualVertex+" ");
				
			}
		}
		else{
			System.out.println("There is no path from source to target.");
		}
		
	}

}
