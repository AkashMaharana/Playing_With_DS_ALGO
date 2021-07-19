package com.akash.maharana.tree.traversal;

import java.util.Stack;

public class PreOrderTraversal_Recursive {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		preOrderTraversalIterativeWay(rootNode);
	}
	
	private static void preOrderTraversalIterativeWay(Node node){
		if(node==null){
			return;
		}
		Stack<Node> s =new Stack<>();
		s.push(node);
		while(!s.isEmpty()){
			Node currentNode=s.peek();
			System.out.print(currentNode.getData()+" ");
			currentNode=s.pop();
			if(currentNode.getRightChild()!=null){
				s.push(currentNode.getRightChild());
			}
			if(currentNode.getLeftChild()!=null){
				s.push(currentNode.getLeftChild());
			}
		}
	}

}
