package com.akash.maharana;

public class _14_ReverseALinkedListRecursive {
	
	public static void main(String[] args) {
		LinkedListNode head1=new LinkedListNode(1);
		head1.setNext(new LinkedListNode(2));
		head1.getNext().setNext(new LinkedListNode(3));
		head1.getNext().getNext().setNext(new LinkedListNode(4));
		LinkedListHelper.traverseList(head1);
		LinkedListNode reverseHead=reverse(head1);
		LinkedListHelper.traverseList(reverseHead);
	}
	
	private static LinkedListNode reverse(LinkedListNode head) {
		if(head==null) {
			return head;
		}
		if(head.getNext()==null) {
			return head;
		}
		LinkedListNode newNode=reverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return newNode;
	}

}
