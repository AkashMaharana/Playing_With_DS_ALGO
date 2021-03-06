package spanningTreeKruskal;

public class Vertex {

	private String name;
	private Node node;

	public Vertex(String name) {
		this.name = name;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
