package com.akash.maharana.linkedlist.standard.problem;

public class ReverseALinkedListInGroupSize {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.insert(6);
		l.insert(7);
		l.insert(8);
		l.insert(9);
		l.insert(10);
		Node finalNode=reverseLinkedListInGroupSize(l.getRootNode(),4);
		l.traverseList(finalNode);
	}
	
	private static Node reverseLinkedListInGroupSize(Node head,int groupSize){
		Node previousNode=null;
		Node currentNode=head;
		Node nextNode=null;
		int count=0;
		while(count<groupSize && currentNode!=null){
			nextNode=currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode=currentNode;
			currentNode=nextNode;
			count++;
		}
		if(nextNode!=null){
			head.setNextNode(reverseLinkedListInGroupSize(nextNode, groupSize));
		}
		
		return previousNode;
	}

}
