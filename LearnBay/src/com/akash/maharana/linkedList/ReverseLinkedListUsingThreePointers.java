package com.akash.maharana.linkedList;

public class ReverseLinkedListUsingThreePointers {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);
		l.insert(60);
		l.traverseListWithHead(reverseUsingPointers(l.getRootNode()));
	}
	
	private static Node reverseUsingPointers(Node node){
		Node currentNode=node;
		Node previousNode=null;
		Node nextNode=null;
		while(currentNode!=null){
			nextNode=currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}

}
