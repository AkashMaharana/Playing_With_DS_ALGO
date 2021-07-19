package bellManFordShortestPath;

import java.util.List;

public class BellManFord {
	
	private List<Edge> edgeList;
	private List<Vertex> vertexList;
	
	public BellManFord(List<Edge> edgeList,List<Vertex> vertexList){
		this.edgeList=edgeList;
		this.vertexList=vertexList;
	}
	
	public void bellManFord(Vertex sourceVertex){
		sourceVertex.setDistance(0);
		for(int i=0;i<vertexList.size()-1;i++){
			for(Edge edge : edgeList){
				Vertex start=edge.getStartVertex();
				Vertex end=edge.getTargetVertex();
				if(start.getDistance()==Double.MAX_VALUE){
					continue;
				}
				double newDistance=start.getDistance()+edge.getWeight();
				if(newDistance<end.getDistance()){
					end.setDistance(newDistance);
					end.setPredecessor(start);
				}
			}
		}
		for(Edge edge : edgeList){
			if(edge.getStartVertex().getDistance()!=Double.MAX_VALUE){
				if(hasCycle(edge)){
					System.out.println("Cycle detected");
					return;
				}
			}
		}
	}
	
	private boolean hasCycle(Edge edge){
		return edge.getStartVertex().getDistance()+edge.getWeight()<edge.getTargetVertex().getDistance();
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
