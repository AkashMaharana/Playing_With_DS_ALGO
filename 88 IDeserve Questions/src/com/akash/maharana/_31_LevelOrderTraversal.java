package com.akash.maharana;

import java.util.LinkedList;
import java.util.Queue;

public class _31_LevelOrderTraversal {
	
	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode(1);
		root.setLeft(new BinaryTreeNode(2));
		root.setRight(new BinaryTreeNode(3));
		root.getLeft().setLeft(new BinaryTreeNode(4));
		root.getLeft().setRight(new BinaryTreeNode(5));
		root.getLeft().getRight().setLeft(new BinaryTreeNode(8));
		root.getLeft().getRight().getLeft().setRight(new BinaryTreeNode(9));
		root.getRight().setLeft(new BinaryTreeNode(6));
		root.getRight().setRight(new BinaryTreeNode(7));
		root.getRight().getRight().setRight(new BinaryTreeNode(10));
		root.getRight().getRight().getRight().setLeft(new BinaryTreeNode(4));
		levelOrderTraversal(root);
	}
	
	private static void levelOrderTraversal(BinaryTreeNode node) {
		Queue<BinaryTreeNode> tempQueue=new LinkedList<>();
		tempQueue.add(node);
		while(!tempQueue.isEmpty()) {
			BinaryTreeNode tempNode=tempQueue.remove();
			if(tempNode.getLeft()!=null) {
				tempQueue.add(tempNode.getLeft());
			}
			if(tempNode.getRight()!=null) {
				tempQueue.add(tempNode.getRight());
			}
			System.out.print(tempNode.getData()+" ");
		}
	}
	
	

}


