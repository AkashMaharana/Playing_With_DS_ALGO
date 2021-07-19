package graphBFS;

import java.util.Queue;
import java.util.LinkedList;

public class BFSImpl {
	
	public void bfs(Vertex vertex){
		Queue<Vertex> q=new LinkedList<>();
		q.add(vertex);
		vertex.setVisited(true);
		while(!q.isEmpty()){
			Vertex tempVertex=q.poll();
			System.out.print("Temp Vertex : "+tempVertex+" : ");
			for(Vertex v : tempVertex.getNeighourList()){
				if(!v.isVisited()){
					System.out.print(v.getData()+" ");
					v.setVisited(true);
					q.add(v);
				}
			}
			System.out.println();
		}
	}

}
