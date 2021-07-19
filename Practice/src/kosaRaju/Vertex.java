package kosaRaju;

import java.util.List;
import java.util.ArrayList;

public class Vertex {

	private String name;
	private boolean isVisited;
	private List<Vertex> adjacenciesList;
	private int componentId;
	private int id;

	public Vertex(int id, String name) {
		this.id = id;
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public List<Vertex> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Vertex> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void addVertex(Vertex vertex ) {
		this.adjacenciesList.add(vertex);
	}

}
