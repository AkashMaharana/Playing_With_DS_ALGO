package com.akash.maharana;

public class _22_DeleteMiddleNodeOfALinkedList {
	
	public static void main(String[] args) {
		LinkedListNode head=new LinkedListNode(1);
		head.setNext(new LinkedListNode(2));
		head.getNext().setNext(new LinkedListNode(3));
		head.getNext().getNext().setNext(new LinkedListNode(4));
		head.getNext().getNext().getNext().setNext(new LinkedListNode(5));
		LinkedListHelper.traverseList(head);
		deleteMiddle(head.getNext().getNext());
		LinkedListHelper.traverseList(head);
	}
	
	private static void deleteMiddle(LinkedListNode node) {
		LinkedListNode temp=node.getNext().getNext();
		node.setData(node.getNext().getData());
		node.setNext(temp);
	}

}
