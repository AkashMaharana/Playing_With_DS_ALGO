package com.akash.maharana;

public class _21_RecoverBinaryTreeWhereTwoNodesAreSwapped {
	
	private static BinaryTreeNode firstNode=null;
	private static BinaryTreeNode middleNode=null;
	private static BinaryTreeNode lastNode=null;
	private static BinaryTreeNode previousNode=null;
	
	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode(10);
		root.setLeft(new BinaryTreeNode(5));
		root.setRight(new BinaryTreeNode(8));
		root.getLeft().setLeft(new BinaryTreeNode(2));
		root.getLeft().setRight(new BinaryTreeNode(20));
		BinaryTreeHelper.traverseTree(root);
		System.out.println();
		recoverTree(root);
		BinaryTreeHelper.traverseTree(root);
	}
	
	private static void recoverTree(BinaryTreeNode node) {
		correctBinarySearchTree(node);
		if(firstNode!=null && lastNode!=null) {
			int temp=firstNode.getData();
			firstNode.setData(lastNode.getData());
			lastNode.setData(temp);
		}
		else if(firstNode!=null && middleNode!=null) {
			int temp=firstNode.getData();
			firstNode.setData(middleNode.getData());
			middleNode.setData(temp);
		}
	}

	private static void correctBinarySearchTree(BinaryTreeNode node) {
		if(node!=null) {
			correctBinarySearchTree(node.getLeft());
			if(previousNode!=null && node.getData()<previousNode.getData()) {
				if(firstNode==null) {
					firstNode=previousNode;
					middleNode=node;
				}
				else {
					lastNode=node;
				}
			}
			previousNode=node;
			correctBinarySearchTree(node.getRight());
		}
	}

}
