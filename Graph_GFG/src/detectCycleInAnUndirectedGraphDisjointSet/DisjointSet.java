package detectCycleInAnUndirectedGraphDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
	
	private int nodeCount=0;
	private int setCount=0;
	private List<Node> rootNodes;
	
	public DisjointSet(List<Vertex> vertexList){
		this.rootNodes=new ArrayList<>(vertexList.size());
		makeSets(vertexList);
	}
	
	public void makeSets(List<Vertex> vertexList){
		for(Vertex vertex : vertexList){
			makeSet(vertex);
		}
	}
	
	public void makeSet(Vertex vertex){
		Node newNode=new Node(0,rootNodes.size(),null);
		vertex.setNode(newNode);
		this.rootNodes.add(newNode);
		this.nodeCount++;
		this.setCount++;
	}
	
	public int find(Node node){
		Node currentNode=node;
		while(currentNode.getParent()!=null){
			currentNode=currentNode.getParent();
		}
		Node rootNode=currentNode;
		currentNode=node;
		while(currentNode!=rootNode){
			Node tempNode=currentNode.getParent();
			currentNode.setParent(rootNode);
			currentNode=tempNode;
		}
		return rootNode.getId();
	}
	
	public void union(Node node1,Node node2){
		int index1=find(node1);
		int index2=find(node2);
		if(index1==index2){
			return;
		}
		Node root1=this.rootNodes.get(index1);
		Node root2=this.rootNodes.get(index2);
		if(root1.getRank()>root2.getRank()){
			root2.setParent(root1);
		}
		else if(root1.getRank()<root2.getRank()){
			root1.setParent(root2);
		}
		else{
			root2.setParent(root1);
			root1.setRank(root1.getRank()+1);
		}
		this.setCount--;
	}

}
