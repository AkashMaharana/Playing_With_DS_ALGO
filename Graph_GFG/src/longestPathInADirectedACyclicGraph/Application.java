package longestPathInADirectedACyclicGraph;

public class Application {
	
	public static void main(String[] args) {
		Graph graph=new Graph(8);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 7);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);
		graph.addEdge(3, 7);
		graph.addEdge(4, 7);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		System.out.println(graph.longestPath());
	}

}
