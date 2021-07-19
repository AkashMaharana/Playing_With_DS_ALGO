package biConnectedComponentOfAGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ArticulationPoint<T> {
	
	private int time;
	
	public void findAllArticulationPoints(Graph<T> graph){
		time=0;
		Set<Vertex<T>> articulationPointset=new HashSet<>();
		Set<Vertex<T>> visitedSet=new HashSet<>();
		Map<Vertex<T>,Integer> visitedTime=new HashMap<>();
		Map<Vertex<T>,Integer> lowTime=new HashMap<>();
		Map<Vertex<T>,Vertex<T>> parent=new HashMap<>();
		Vertex<T> startVertex=graph.getAllVertex().iterator().next();
		Queue<Vertex<T>> biConnectedComponents=new LinkedList<>();
		dfs(articulationPointset,visitedSet,visitedTime,lowTime,parent,startVertex,biConnectedComponents);
	}
	
	private void dfs(Set<Vertex<T>> articulationPointset,Set<Vertex<T>> visitedSet,Map<Vertex<T>,Integer> visitedTime,
			Map<Vertex<T>,Integer> lowTime,Map<Vertex<T>,Vertex<T>> parent,Vertex<T> startVertex,Queue<Vertex<T>> biConnectedComponents){
		visitedSet.add(startVertex);
		visitedTime.put(startVertex, time);
		lowTime.put(startVertex, time);
		int childCount=0;
		time++;
		boolean isArticulationPoint=false;
		biConnectedComponents.add(startVertex);
		for(Vertex<T> currentVertex : startVertex.getAdjacentVertexes()){
			if(currentVertex.equals(parent.get(startVertex))){
				continue;
			}
			if(!visitedSet.contains(currentVertex)){
				visitedSet.add(currentVertex);
				parent.put(currentVertex, startVertex);
				childCount++;
				dfs(articulationPointset,visitedSet,visitedTime,lowTime,parent,currentVertex,biConnectedComponents);
				if(visitedTime.get(startVertex)<=lowTime.get(currentVertex)){
					isArticulationPoint=true;
					printQueue(biConnectedComponents);
				}
				else{
					lowTime.put(startVertex, Math.min(time, lowTime.get(currentVertex)));
				}
			}
			else{
				lowTime.put(startVertex, Math.min(time, lowTime.get(currentVertex)));
			}
		}
		if((parent.get(startVertex)==null && childCount==2) || (parent.get(startVertex)!=null && isArticulationPoint)){
			articulationPointset.add(startVertex);
		}
	}
	
	private void printQueue(Queue<Vertex<T>> biConnectedComponents){
		while(!biConnectedComponents.isEmpty()){
			System.out.print(biConnectedComponents.remove());
		}
		System.out.println();
		System.out.println("--------------------------------");
	}

}
