package directedAcyclicGraphShortestpath;

import java.util.List;
import java.util.ArrayList;

public class Vertex {
	
	private String name;
	private boolean isIdentified;
	private List<Edge> adjacenciesList;
	private Vertex predecessor;
	private double minimumDistance=Double.MAX_VALUE;
	
	public Vertex(String name){
		this.name=name;
		this.adjacenciesList=new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIdentified() {
		return isIdentified;
	}

	public void setIdentified(boolean isIdentified) {
		this.isIdentified = isIdentified;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public double getMinimumDistance() {
		return minimumDistance;
	}

	public void setMinimumDistance(double minimumDistance) {
		this.minimumDistance = minimumDistance;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public void addNeighbour(Edge edge){
		this.adjacenciesList.add(edge);
	}

}
