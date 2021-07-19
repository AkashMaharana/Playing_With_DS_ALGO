package directedAcylicGraphShortestPath;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		Vertex v0 = new Vertex("r");
		Vertex v1 = new Vertex("t");
		Vertex v2 = new Vertex("x");
		Vertex v3 = new Vertex("s");
		Vertex v4 = new Vertex("y");
		Vertex v5 = new Vertex("z");

		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(v0);
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);

		v0.addEdge(new Edge(3, v0, v1));
		v0.addEdge(new Edge(5, v0, v3));

		v1.addEdge(new Edge(7, v1, v2));
		v1.addEdge(new Edge(4, v1, v4));
		v1.addEdge(new Edge(2, v1, v5));

		v2.addEdge(new Edge(-1, v2, v4));
		v2.addEdge(new Edge(1, v2, v5));

		v3.addEdge(new Edge(6, v3, v2));

		v4.addEdge(new Edge(-2, v4, v5));

		DAGShortestPath dag = new DAGShortestPath();
		dag.getShortestPath(vertexList, v0, v5);

	}

}
