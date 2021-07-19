package biConnectedComponentOfAGraph;

public class BiConnectedComponent {

	public static void main(String[] args) {
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
		System.out.println("Bi-Connected Components");
		System.out.println("---------------------");
		ArticulationPoint<Integer> ap = new ArticulationPoint<Integer>();
		ap.findAllArticulationPoints(graph);
	}

}
