package longestPathInADirectedACyclicGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Graph {

	private int noOfVertex;
	private LinkedList<Integer>[] adjacenciesList;

	public Graph(int noOfVertex) {
		this.noOfVertex = noOfVertex;
		this.adjacenciesList = new LinkedList[this.noOfVertex];
		for (int i = 0; i < this.noOfVertex; i++) {
			this.adjacenciesList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		this.adjacenciesList[source].add(destination);
	}

	public int longestPath() {
		int longestPathValue = 0;
		int[] indegreeArray = new int[this.noOfVertex];
		int[] longestPathArray = new int[this.noOfVertex];
		for (int i = 0; i < this.noOfVertex; i++) {
			for (int temp : this.adjacenciesList[i]) {
				indegreeArray[temp] = indegreeArray[temp] + 1;
			}
		}
		Queue<Integer> indegreeQueue = new LinkedList<>();
		for (int i = 0; i < indegreeArray.length; i++) {
			if (indegreeArray[i] == 0) {
				indegreeQueue.add(i);
			}
		}
		int count = 0;
		Vector<Integer> result = new Vector<>();
		while (!indegreeQueue.isEmpty()) {
			int tempValue = indegreeQueue.poll();
			result.add(tempValue);
			for (int value : this.adjacenciesList[tempValue]) {
				indegreeArray[value] = indegreeArray[value] - 1;
				longestPathArray[value] = Math.max(longestPathArray[value], longestPathArray[tempValue] + 1);
				if (longestPathValue < longestPathArray[value]) {
					longestPathValue = longestPathArray[value];
				}
				if (indegreeArray[value] == 0) {
					indegreeQueue.add(value);
				}
			}
			count = count + 1;
		}
		if (count != this.noOfVertex) {
			System.out.println("There is a cycle in the graph");
			return -1;
		}
		return longestPathValue;
	}

}
