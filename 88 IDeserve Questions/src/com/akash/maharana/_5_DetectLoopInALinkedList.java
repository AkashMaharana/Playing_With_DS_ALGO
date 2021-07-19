package com.akash.maharana;

public class _5_DetectLoopInALinkedList {
	
	public static void main(String[] args) {
		LinkedListNode node1=new LinkedListNode(1);
		node1.setNext(new LinkedListNode(2));
		node1.getNext().setNext(new LinkedListNode(3));
		node1.getNext().getNext().setNext(new LinkedListNode(4));
		node1.getNext().getNext().getNext().setNext(new LinkedListNode(5));
		node1.getNext().getNext().getNext().getNext().setNext(node1.getNext());
		deleteLoopFromLinkedList(node1);
		LinkedListHelper.traverseList(node1);
	}
	
	private static void deleteLoopFromLinkedList(LinkedListNode node) {
		LinkedListNode slowPointer=node;
		LinkedListNode firstPointer=node;
		while(slowPointer!=null && firstPointer!=null && firstPointer.getNext()!=null) {
			slowPointer=slowPointer.getNext();
			firstPointer=firstPointer.getNext().getNext();
			if(slowPointer==firstPointer) {
				break;
			}
		}
		slowPointer=node;
		while(slowPointer!=null && firstPointer!=null) {
			if(slowPointer==firstPointer) {
				break;
			}
			else {
				slowPointer=slowPointer.getNext();
				firstPointer=firstPointer.getNext();
			}
		}
		firstPointer=slowPointer;
		while(firstPointer.getNext()!=null) {
			if(firstPointer.getNext()==slowPointer) {
				firstPointer.setNext(null);
			}
			else {
				firstPointer=firstPointer.getNext();
			}
		}
	}

}
