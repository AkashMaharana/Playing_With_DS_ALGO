package com.akash.maharana.tree.standard.problem;

public class LowestCommonAncestor {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(8));
		rootNode.getLeftChild().getLeftChild().setRightChild(new Node(9));
		rootNode.getLeftChild().getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(11));
		rootNode.getRightChild().getRightChild().getRightChild().setLeftChild(new Node(12));
		rootNode.getRightChild().getRightChild().getRightChild().setRightChild(new Node(13));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(14));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node(16));
		rootNode.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(17));
		System.out.println(lowestCommonAncestor(rootNode,new Node(11),new Node(14)).getData());
	}
	
	private static Node lowestCommonAncestor(Node node,Node firstNode,Node secondNode){
		if(node==null){
			return null;
		}
		if(firstNode.getData()==node.getData() ||secondNode.getData()==node.getData()){
			return node;
		}
		Node leftNode=lowestCommonAncestor(node.getLeftChild(), firstNode, secondNode);
		Node rightNode=lowestCommonAncestor(node.getRightChild(), firstNode, secondNode);
		if(leftNode!=null && rightNode!=null){
			return node;
		}
		else{
			if(leftNode==null){
				return rightNode;
			}
			if(rightNode==null){
				return leftNode;
			}
		}
		return null;
	}

}
