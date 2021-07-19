package snakeAndLadderProblem;

public class Node {

	private int distance;
	private int vertexNumber;

	public Node(int distance, int vertexNumber) {
		this.distance = distance;
		this.vertexNumber = vertexNumber;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public void setVertexNumber(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

}
