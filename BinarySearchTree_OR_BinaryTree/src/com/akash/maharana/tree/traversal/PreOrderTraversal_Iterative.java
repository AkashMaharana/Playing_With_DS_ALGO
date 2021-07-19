package com.akash.maharana.tree.traversal;

public class PreOrderTraversal_Iterative {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		preOrderTraversalRecursiveWay(rootNode);
	}
	
	private static void preOrderTraversalRecursiveWay(Node node){
		System.out.print(node.getData()+" ");
		if(node.getLeftChild()!=null){
			preOrderTraversalRecursiveWay(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			preOrderTraversalRecursiveWay(node.getRightChild());
		}
	}

}
