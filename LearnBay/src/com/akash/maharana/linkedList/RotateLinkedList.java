package com.akash.maharana.linkedList;

public class RotateLinkedList {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);
		l.insert(60);
		l.traverseList();
		System.out.println();
		l.traverseListWithHead(rotateList(l.getRootNode(),2));
	}
	
	public static Node rotateList(Node node,int noOfMove){
		Node headNode=node;
		Node tailNode=null;
		while(node.getNextNode()!=null){
			node=node.getNextNode();
		}
		tailNode=node;
		Node nextToHead=null;
		while(noOfMove>0){
			nextToHead=headNode.getNextNode();
			headNode.setNextNode(null);
			tailNode.setNextNode(headNode);
			tailNode=headNode;
			headNode=nextToHead;
			noOfMove--;
		}
		return headNode;
	}

}
