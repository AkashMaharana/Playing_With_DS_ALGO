package com.akash.maharana;

public class _20_ReverseALinkedListIterative {
	
	public static void main(String[] args) {
		LinkedListNode head=new LinkedListNode(1);
		head.setNext(new LinkedListNode(2));
		head.getNext().setNext(new LinkedListNode(3));
		head.getNext().getNext().setNext(new LinkedListNode(4));
		head.getNext().getNext().getNext().setNext(new LinkedListNode(5));
		LinkedListHelper.traverseList(head);
		LinkedListNode newHead=reverseList(head);
		LinkedListHelper.traverseList(newHead);
	}
	
	private static LinkedListNode reverseList(LinkedListNode head) {
		LinkedListNode previuosNode=null;
		LinkedListNode currentNode=head;
		LinkedListNode nextNode=null;
		while(currentNode!=null) {
			nextNode=currentNode.getNext();
			currentNode.setNext(previuosNode);
			previuosNode=currentNode;
			currentNode=nextNode;
		}
		return previuosNode;
	}

}
