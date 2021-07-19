package bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	
	public void traverse(Vertex root) {
		Queue<Vertex> queue=new LinkedList<>();
		root.setVisited(true);
		queue.add(root);
		while(!queue.isEmpty()) {
			Vertex temp=queue.poll();
			System.out.println(temp);
			List<Vertex> list=temp.getNeighbourList();
			for(Vertex vertex : list) {
				if(!vertex.isVisited()) {
					queue.add(vertex);
					vertex.setVisited(true);
				}
			}
		}
	}

}
