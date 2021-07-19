package com.akash.maharana;

public class ReverseADoublyLinkedList {
	
	public static void main(String[] args) {
		DoublyNode head=new DoublyNode(1);
		head.next=new DoublyNode(2);
		head.prev=null;
		head.next.prev=head;
		head.next.next=new DoublyNode(3);
		head.next.next.prev=head.next;
		traverseList(head);
		DoublyNode reverseHead=reverseDoublyLinkedList(head);
		traverseList(reverseHead);
	}
	
	private static DoublyNode reverseDoublyLinkedList(DoublyNode node) {
		DoublyNode temp=null;
		DoublyNode current=node;
		while(current!=null) {
			temp=current.prev;
			current.prev=current.next;
			current.next=temp;
			current=current.prev;
		}
		return temp.prev;
	}
	
	private static void traverseList(DoublyNode node) {
		while(node!=null) {
			System.out.print(node.data+"->");
			node=node.next;
		}
		System.out.println();
	}

}

class DoublyNode{
	int data;
	DoublyNode prev;
	DoublyNode next;
	
	public DoublyNode(int data) {
		this.data=data;
		this.prev=null;
		this.next=null;
	}
}
