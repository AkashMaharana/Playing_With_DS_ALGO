package kruskalMST;

import java.util.List;
import java.util.ArrayList;

public class DisjointSet {

	private int nodeCount=0;
	private int setCount=0;
	private List<Node> rootNodes;
	
	public DisjointSet(List<Vertex> vertexes){
		this.rootNodes=new ArrayList<>(vertexes.size()); 
		makeSets(vertexes);
	}
	
	private void makeSets(List<Vertex> vertexes){
		for(Vertex v : vertexes){
			makeSet(v);
		}
	}
	
	private void makeSet(Vertex vertex){
		Node node=new Node(0,rootNodes.size(),null);
		vertex.setNode(node);
		this.rootNodes.add(node);
		this.setCount++;
		this.nodeCount++;
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
		if(root1.getRank()<root2.getRank()){
			root1.setParent(root2);
		}
		else if(root1.getRank()>root2.getRank()){
			root2.setParent(root1);
		}
		else{
			root2.setParent(root1);
			root1.setRank(root1.getRank()+1);
		}
		this.setCount--;
	}
	
}
