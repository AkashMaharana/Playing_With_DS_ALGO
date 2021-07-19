package cycleDetection;

import java.util.List;

public class CycleDetection {
	
	public void detectCycle(List<Vertex> vertexList) {
		for(Vertex temp : vertexList) {
			if(!temp.isVisited()) {
				isCyclePresent(temp);
			}
		}
	}
	
	private void isCyclePresent(Vertex vertex) {
		vertex.setBeingVisited(true);
		for(Vertex temp : vertex.getNeighbourList()) {
			if(temp.isBeingVisited()) {
				System.out.println("Cycle Detected");
				return;
			}
			if(!temp.isVisited()) {
				temp.setBeingVisited(true);
				isCyclePresent(temp);
			}
		}
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}

}
