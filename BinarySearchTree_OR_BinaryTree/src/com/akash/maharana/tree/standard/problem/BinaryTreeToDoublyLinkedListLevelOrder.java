package com.akash.maharana.tree.standard.problem;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeToDoublyLinkedListLevelOrder {
	
	NodeLevelOrder root;
	NodeLevelOrder head;
	static NodeLevelOrder previous;
	
	public static void main(String[] args) {
		BinaryTreeToDoublyLinkedListLevelOrder tree = new BinaryTreeToDoublyLinkedListLevelOrder();
		tree.root = new NodeLevelOrder(10);
		tree.root.left = new NodeLevelOrder(12);
		tree.root.right = new NodeLevelOrder(15);
		tree.root.left.left = new NodeLevelOrder(25);
		tree.root.left.right = new NodeLevelOrder(30);
		tree.root.right.left = new NodeLevelOrder(36);
		tree.binaryTree2DoubleLinkedList(tree.root);
		tree.printList(tree.head);
	}
	
	void binaryTree2DoubleLinkedList(NodeLevelOrder node){
		if(node==null){
			return;
		}
		Queue<NodeLevelOrder> q=new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			NodeLevelOrder tempNode=q.poll();
			NodeLevelOrder newNode=new NodeLevelOrder(tempNode.data);
			if(previous==null){
				head=newNode;
			}
			else{
				newNode.left=previous;
				previous.right=newNode;
			}
			previous=newNode;
			if(tempNode.left!=null){
				q.add(tempNode.left);
			}
			if(tempNode.right!=null){
				q.add(tempNode.right);
			}
		}
	}
	
	void printList(NodeLevelOrder node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

}

class NodeLevelOrder {
	int data;
	NodeLevelOrder left;
	NodeLevelOrder right;

	NodeLevelOrder(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
