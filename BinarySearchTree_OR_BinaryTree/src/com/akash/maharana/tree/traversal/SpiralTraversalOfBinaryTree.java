package com.akash.maharana.tree.traversal;

import java.util.Stack;

public class SpiralTraversalOfBinaryTree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(8));
		rootNode.setRightChild(new Node(5));
		rootNode.getLeftChild().setLeftChild(new Node(90));
		rootNode.getLeftChild().setRightChild(new Node(56));
		rootNode.getRightChild().setLeftChild(new Node(23));
		rootNode.getRightChild().setRightChild(new Node(19));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(89));
		spiralTraversal(rootNode);
	}
	
	private static void spiralTraversal(Node node){
		Stack<Node> s1=new Stack<>();
		Stack<Node> s2=new Stack<>();
		if(node==null){
			return;
		}
		else{
			s1.push(node);
		}
		spiralTreeTraversal(node,s1,s2);
	}
	
	private static void spiralTreeTraversal(Node node,Stack<Node> s1,Stack<Node> s2){
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				Node tempNode=s1.pop();
				System.out.print(tempNode.getData()+" ");
				if(tempNode.getLeftChild()!=null){
					s2.push(tempNode.getLeftChild());
				}
				if(tempNode.getRightChild()!=null){
					s2.push(tempNode.getRightChild());
				}
			}
			while(!s2.isEmpty()){
				Node tempNode=s2.pop();
				System.out.print(tempNode.getData()+" ");
				if(tempNode.getRightChild()!=null){
					s1.push(tempNode.getRightChild());
				}
				if(tempNode.getLeftChild()!=null){
					s1.push(tempNode.getLeftChild());
				}
				
			}
		}
	}

}
