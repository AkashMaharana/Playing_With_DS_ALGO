package com.akash.maharana.tree.standard.problem;

import java.util.Stack;

public class InOrderPredecessorOfABinarySearchTree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(50);
		rootNode.setLeftChild(new Node(16));
		rootNode.setRightChild(new Node(90));
		rootNode.getLeftChild().setLeftChild(new Node(14));
		rootNode.getLeftChild().setRightChild(new Node(40));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode.getLeftChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getLeftChild().getRightChild().setLeftChild(new Node(35));
		rootNode.getLeftChild().getRightChild().setRightChild(new Node(45));
		rootNode.getLeftChild().getRightChild().getLeftChild().setLeftChild(new Node(32));
		rootNode.getLeftChild().getRightChild().getLeftChild().setRightChild(new Node(36));
		rootNode.getLeftChild().getRightChild().getLeftChild().getRightChild().setRightChild(new Node(37));
		rootNode.getRightChild().setRightChild(new Node(100));
		rootNode.getRightChild().setLeftChild(new Node(78));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(75));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(82));
		rootNode.getRightChild().getLeftChild().getRightChild().setLeftChild(new Node(81));
		rootNode.getRightChild().getLeftChild().getRightChild().getLeftChild().setLeftChild(new Node(79));
		rootNode.getRightChild().getLeftChild().getRightChild().setRightChild(new Node(85));
		rootNode.getRightChild().getLeftChild().getRightChild().getRightChild().setRightChild(new Node(87));
		inOrderTraversal(rootNode);
		System.out.println();
		System.out.println("In Order Predecessor : "+inOrderPredecessor(rootNode,75));
		System.out.println("In Order Successor : "+inOrderSuccessor(rootNode, 37));
	}
	
	private static int inOrderSuccessor(Node node,int data){
		Node tempNode=null;
		while(node!=null){
			if(node.getData()==data){
				break;
			}
			if(node.getData()>data){
				tempNode=node;
				node=node.getLeftChild();
				continue;
			}
			if(node.getData()<data){
				node=node.getRightChild();
				continue;
			}
		}
		return tempNode.getData();
	}
	
	private static int inOrderPredecessor(Node node,int data){
		Node tempNode=null;
		while(node!=null){
			if(node.getData()==data){
				break;
			}
			if(node.getData()<data){
				tempNode=node;
				node=node.getRightChild();
				continue;
			}
			if(node.getData()>data){
				node=node.getLeftChild();
				continue;
			}
		}
		return tempNode.getData();
	}
	
	private static void inOrderTraversal(Node node){
		if(node==null){
			return;
		}
		Stack<Node> s=new Stack<>();
		while(true){
			while(node!=null){
				s.push(node);
				node=node.getLeftChild();
			}
			if(s.isEmpty()){
				break;
			}
			Node tempNode=s.pop();
			System.out.print(tempNode.getData()+" ");
			node=tempNode.getRightChild();
		}
	}
}	