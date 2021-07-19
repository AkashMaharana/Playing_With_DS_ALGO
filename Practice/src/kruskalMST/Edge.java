package kruskalMST;

public class Edge implements Comparable<Edge> {

	private double weight;
	private Vertex startVertex;
	private Vertex endVertex;

	public Edge(Vertex startVertex, Vertex endVertex, double weight) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.endVertex = endVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	public void setEndVertex(Vertex endVertex) {
		this.endVertex = endVertex;
	}

	@Override
	public int compareTo(Edge edge) {
		return Double.compare(this.weight, edge.getWeight());
	}

}
