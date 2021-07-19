package representationOfGraph;

public class Application {
	
	public static void main(String[] args) {
		AdjacenyListGraph alg=new AdjacenyListGraph(5);
		alg.addEdge(alg, 0, 1);
		alg.addEdge(alg, 0, 4);
		alg.addEdge(alg, 1, 2);
		alg.addEdge(alg, 1, 3);
		alg.addEdge(alg, 1, 4);
		alg.addEdge(alg, 2, 3);
		alg.addEdge(alg, 3, 4);
		alg.printGraph(alg);
	}

}
