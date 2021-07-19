package com.akash.maharana;

import java.util.LinkedList;
import java.util.Queue;

public class _10_FindMinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.setLeft(new BinaryTreeNode(2));
		root.setRight(new BinaryTreeNode(3));
		root.getLeft().setLeft(new BinaryTreeNode(4));
		root.getRight().setLeft(new BinaryTreeNode(5));
		root.getRight().setRight(new BinaryTreeNode(6));
		root.getRight().getLeft().setRight(new BinaryTreeNode(7));
		root.getRight().getRight().setLeft(new BinaryTreeNode(8));
		System.out.println("Minimum Depth Inorder Traversal : "+minimumDepth(root));
		System.out.println("Minimum Depth Level Order Traversal : "+minimumDepthLevelOrder(root));
	}

	//In Order Traversal approach
	private static int minimumDepth(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		if (node.getLeft() == null) {
			return minimumDepth(node.getRight()) + 1;
		}
		if (node.getRight() == null) {
			return minimumDepth(node.getLeft()) + 1;
		}
		return Math.min(minimumDepth(node.getLeft()), minimumDepth(node.getRight())) + 1;
	}
	
	//Level order traversal approach
	private static int minimumDepthLevelOrder(BinaryTreeNode node) {
		if(node==null) {
			return 0;
		}
		Queue<QueueNode> queue=new LinkedList<>();
		queue.add(new QueueNode(node, 1));
		QueueNode temp=null;
		while(!queue.isEmpty()) {
			temp=queue.remove();
			if(temp.node.getLeft()==null && temp.node.getRight()==null) {
				return temp.depth;
			}
			if(temp.node.getLeft()!=null) {
				queue.add(new QueueNode(temp.node.getLeft(), temp.depth+1));
			}
			if(temp.node.getRight()!=null) {
				queue.add(new QueueNode(temp.node.getRight(), temp.depth+1));
			}
		}
		return 0;
	}
}

class QueueNode{
	BinaryTreeNode node;
	int depth;
	
	public QueueNode(BinaryTreeNode node,int depth) {
		this.node=node;
		this.depth=depth;
	}
}
