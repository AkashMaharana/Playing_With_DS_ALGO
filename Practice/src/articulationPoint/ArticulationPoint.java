package articulationPoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArticulationPoint<T> {

	private int time;

	public Set<Vertex<T>> findarticulationPoints(Graph<T> graph) {
		time = 0;
		Set<Vertex<T>> visitedSet = new HashSet<>();
		Set<Vertex<T>> articulationPointSet = new HashSet<>();
		Map<Vertex<T>, Integer> visitedTime = new HashMap<>();
		Map<Vertex<T>, Integer> lowTime = new HashMap<>();
		Map<Vertex<T>, Vertex<T>> parent = new HashMap<>();
		Vertex<T> startVertex = graph.getAllVertex().iterator().next();
		dfs(visitedSet, articulationPointSet, visitedTime, lowTime, parent, startVertex);
		return articulationPointSet;
	}

	public void dfs(Set<Vertex<T>> visitedSet, Set<Vertex<T>> articulationPointSet, Map<Vertex<T>, Integer> visitedTime,
			Map<Vertex<T>, Integer> lowTime, Map<Vertex<T>, Vertex<T>> parent, Vertex<T> startVertex) {
		visitedSet.add(startVertex);
		visitedTime.put(startVertex, time);
		lowTime.put(startVertex, time);
		time++;
		int childCount = 0;
		boolean isArticulationPoint = false;
		for (Vertex<T> currentVertex : startVertex.getAdjacentVertexes()) {
			if (currentVertex.equals(parent.get(startVertex))) {
				continue;
			}
			if (!visitedSet.contains(currentVertex)) {
				visitedSet.add(currentVertex);
				parent.put(currentVertex, startVertex);
				childCount++;
				dfs(visitedSet, articulationPointSet, visitedTime, lowTime, parent, currentVertex);
				if (visitedTime.get(startVertex) <= lowTime.get(currentVertex)) {
					isArticulationPoint = true;
				} else {
					lowTime.put(startVertex, Math.min(time, lowTime.get(currentVertex)));
				}
			} else {
				lowTime.put(startVertex, Math.min(time, visitedTime.get(currentVertex)));
			}
		}
		if ((parent.get(startVertex) == null && childCount >= 2)
				|| parent.get(startVertex) != null && isArticulationPoint) {
			articulationPointSet.add(startVertex);
		}
	}

	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<>(false);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 5);
		graph.addEdge(6, 8);

		// bigger example
		/*
		 * graph.addEdge(0, 1); graph.addEdge(0, 2); graph.addEdge(0, 3);
		 * graph.addEdge(0, 4); graph.addEdge(4, 2); graph.addEdge(3, 5);
		 * graph.addEdge(4, 6); graph.addEdge(6, 3); graph.addEdge(6, 7);
		 * graph.addEdge(6, 8); graph.addEdge(7, 9); graph.addEdge(9, 10);
		 * graph.addEdge(8, 10);
		 */

		ArticulationPoint<Integer> ap = new ArticulationPoint<Integer>();
		Set<Vertex<Integer>> aPoints = ap.findarticulationPoints(graph);
		aPoints.forEach(point -> System.out.println(point));
	}

}
