package stronglyConnectedComponentsKosaraju;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private int id;
	private List<Vertex> adjacenciesList;
	private boolean isIdentified;
	private int componentId;

	public Vertex(int id, String name) {
		this.name = name;
		this.id = id;
		this.adjacenciesList = new ArrayList<>();
	}

	public void addNeighbour(Vertex vertex) {
		this.adjacenciesList.add(vertex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Vertex> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Vertex> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public boolean isIdentified() {
		return isIdentified;
	}

	public void setIdentified(boolean isIdentified) {
		this.isIdentified = isIdentified;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
