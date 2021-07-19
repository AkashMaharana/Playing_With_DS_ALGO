package com.akash.maharana.tree.node.count;

public class LeafNodeCount {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		System.out.println(leafNodeCountRecursive(rootNode));
	}
	
	private static int leafNodeCountRecursive(Node node){
		if(node==null){
			return 0;
		}
		else if(node.getLeftChild()==null && node.getLeftChild()==null){
			return 1;
		}
		else{
			return leafNodeCountRecursive(node.getLeftChild())+leafNodeCountRecursive(node.getRightChild());
		}
	}
	
	/*private static int leafNodeCountIterative(Node node){
		return 1;
	}*/
	
	

}
