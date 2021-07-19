package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class ReverseALinkedListInAGroupOfGivenSize {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(8);
		printList(list.getRoootNode());
		Node newNode=reverseInAGroupOfGivenSize(list.getRoootNode(),3);
		printList(newNode);
	}
	
	private static void printList(Node node){
		while(node!=null){
			System.out.println(node.getData());
			node=node.getNextNode();
		}
		System.out.println();
	}
	
	private static Node reverseInAGroupOfGivenSize(Node node,int interval){
		Node previousNode=null;
		Node currentNode=node;
		Node nextNode=null;
		int count=0;
		while(count<interval && currentNode!=null){
			nextNode=currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode=currentNode;
			currentNode=nextNode;
			count++;
		}
		if(nextNode!=null){
			node.setNextNode(reverseInAGroupOfGivenSize(nextNode, interval));
		}
		return previousNode;
	}

}
