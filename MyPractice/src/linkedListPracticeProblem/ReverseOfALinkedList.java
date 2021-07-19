package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class ReverseOfALinkedList {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.addNode(60);
		printList(list.getRoootNode());
		Node newRoot=reverseRecursively(list.getRoootNode());
		printList(newRoot);
		Node newReverseNode=reverseIterativelyUsingThreeNode(newRoot);
		printList(newReverseNode);
	}
	
	private static Node reverseIterativelyUsingThreeNode(Node node){
		Node previousNode=null;
		Node currentNode=node;
		Node nextNode=null;
		while(currentNode!=null){
			nextNode=currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}
	
	private static Node reverseRecursively(Node node){
		if(node==null){
			return null;
		}
		if(node.getNextNode()==null){
			return node;
		}
		Node newNode=reverseRecursively(node.getNextNode());
		node.getNextNode().setNextNode(node);
		node.setNextNode(null);
		return newNode;
	}
	
	private static void printList(Node node){
		while(node!=null){
			System.out.println(node.getData());
			node=node.getNextNode();
		}
		System.out.println();
	}

}
