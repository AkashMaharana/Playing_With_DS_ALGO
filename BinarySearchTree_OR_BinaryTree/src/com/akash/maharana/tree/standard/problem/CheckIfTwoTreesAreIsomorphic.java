package com.akash.maharana.tree.standard.problem;

public class CheckIfTwoTreesAreIsomorphic {
	
	public static void main(String[] args) {
		Node rootNode1=new Node(50);
		rootNode1.setLeftChild(new Node(16));
		rootNode1.setRightChild(new Node(90));
		rootNode1.getLeftChild().setLeftChild(new Node(14));
		rootNode1.getLeftChild().setRightChild(new Node(40));
		rootNode1.getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode1.getLeftChild().getLeftChild().setRightChild(new Node(15));
		rootNode1.getLeftChild().getRightChild().setLeftChild(new Node(35));
		rootNode1.getLeftChild().getRightChild().setRightChild(new Node(45));
		rootNode1.getLeftChild().getRightChild().getLeftChild().setLeftChild(new Node(32));
		rootNode1.getLeftChild().getRightChild().getLeftChild().setRightChild(new Node(36));
		
		Node rootNode2=new Node(50);
		rootNode2.setLeftChild(new Node(16));
		rootNode2.setRightChild(new Node(90));
		rootNode2.getLeftChild().setLeftChild(new Node(14));
		rootNode2.getLeftChild().setRightChild(new Node(40));
		rootNode2.getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode2.getLeftChild().getLeftChild().setRightChild(new Node(15));
		rootNode2.getLeftChild().getRightChild().setLeftChild(new Node(35));
		rootNode2.getLeftChild().getRightChild().setRightChild(new Node(45));
		rootNode2.getLeftChild().getRightChild().getLeftChild().setLeftChild(new Node(32));
		rootNode2.getLeftChild().getRightChild().getLeftChild().setRightChild(new Node(36));
		
		System.out.println(isIsomorphic(rootNode1,rootNode2));
	}
	
	private static boolean isIsomorphic(Node node1,Node node2){
		if(node1==null && node2==null){
			return true;
		}
		if(node1==null || node2==null){
			return false;
		}
		if(node1.getData()!=node2.getData()){
			return false;
		}
		return (isIsomorphic(node1.getLeftChild(), node2.getLeftChild()) && isIsomorphic(node1.getRightChild(),node2.getRightChild())) ||
				(isIsomorphic(node1.getLeftChild(), node2.getRightChild()) && isIsomorphic(node1.getRightChild(),node2.getLeftChild()));
	}
	
	

}
