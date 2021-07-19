package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public void bfs(Vertex vertex){
		Queue<Vertex> q=new LinkedList<>();
		q.add(vertex);
		vertex.setVisited(true);
		while(!q.isEmpty()){
			Vertex tempVertex=q.poll();
			System.out.print("Temp Vertex : "+tempVertex+" : ");
			for(Vertex v : tempVertex.getNeighbourList()){
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
