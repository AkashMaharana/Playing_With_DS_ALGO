package date_27_03_2020;

import java.util.Set;
import java.util.HashSet;

import common.SinglyLinkedListNode;

public class DedupLinkedList {

	public static void main(String[] args) {
		SinglyLinkedListNode head=new SinglyLinkedListNode(1);
		head.setNextNode(new SinglyLinkedListNode(2));
		head.getNextNode().setNextNode(new SinglyLinkedListNode(2));
		head.getNextNode().getNextNode().setNextNode(new SinglyLinkedListNode(4));
		head.getNextNode().getNextNode().getNextNode().setNextNode(new SinglyLinkedListNode(4));
		head.getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new SinglyLinkedListNode(1));
		SinglyLinkedListNode.traverse(head);
		
		dedupLinkedListWithHashing(head);
		SinglyLinkedListNode.traverse(head);
		
		dedupLinkedListWithSorting(head);
		SinglyLinkedListNode.traverse(head);
	}
	
	private static void dedupLinkedListWithHashing(SinglyLinkedListNode node) {
		Set<Integer> temp=new HashSet<>();
		SinglyLinkedListNode previousNode=null;
		while(node!=null) {
			if(temp.contains(node.getData())) {
				previousNode.setNextNode(node.getNextNode());
				node=node.getNextNode();
			}
			else {
				temp.add(node.getData());
				previousNode=node;
				node=node.getNextNode();
			}
		}
 	}
	
	private static void dedupLinkedListWithSorting(SinglyLinkedListNode node) {
		SinglyLinkedListNode newNode=mergeSortLinkedList(node);
		SinglyLinkedListNode previouNode=null;
		while(newNode!=null && newNode.getNextNode()!=null) {
			if(newNode.getData()==newNode.getNextNode().getData()) {
				if(previouNode==null) {
					previouNode=newNode;
					newNode=newNode.getNextNode();
				}
				else {
					previouNode.setNextNode(newNode.getNextNode());
					newNode=newNode.getNextNode();
				}
			}
			else {
				previouNode=newNode;
				newNode=newNode.getNextNode();
			}
		}
	}
	
	private static SinglyLinkedListNode mergeSortLinkedList(SinglyLinkedListNode node) {
		if(node==null || node.getNextNode()==null) {
			return node;
		}
		SinglyLinkedListNode middleNode=getMiddle(node);
		SinglyLinkedListNode nextToMiddle=middleNode.getNextNode();
		middleNode.setNextNode(null);
		SinglyLinkedListNode left=mergeSortLinkedList(node);
		SinglyLinkedListNode right=mergeSortLinkedList(nextToMiddle);
		SinglyLinkedListNode newNode=mergeTwoList(left,right);
		return newNode;
	}
	
	private static SinglyLinkedListNode mergeTwoList(SinglyLinkedListNode node1,SinglyLinkedListNode node2) {
		if(node1==null && node2==null) {
			return null;
		}
		if(node1==null) {
			return node2;
		}
		if(node2==null) {
			return node1;
		}
		if(node1.getData()<node2.getData()) {
			node1.setNextNode(mergeTwoList(node1.getNextNode(), node2));
		}
		else {
			SinglyLinkedListNode tempNode=node2;
			node2=node2.getNextNode();
			tempNode.setNextNode(node1);
			node1=tempNode;
			node1.setNextNode(mergeTwoList(node1.getNextNode(),node2));
		}
		return node1;
	}
	
	private static SinglyLinkedListNode getMiddle(SinglyLinkedListNode node) {
		if(node==null) {
			return null;
		}
		SinglyLinkedListNode slowPointer=node;
		SinglyLinkedListNode fastPointer=node;
		while(fastPointer.getNextNode()!=null && fastPointer.getNextNode().getNextNode()!=null) {
			slowPointer=slowPointer.getNextNode();
			fastPointer=fastPointer.getNextNode().getNextNode();
		}
		return slowPointer;
	}
	
	
}
