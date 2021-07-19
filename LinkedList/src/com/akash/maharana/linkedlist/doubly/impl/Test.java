package com.akash.maharana.linkedlist.doubly.impl;

public class Test {
	
	public static void main(String[] args) {
		DoublyLinkedList dbl=new DoublyLinkedList();
		for(int i=0;i<10;i++){
			dbl.insert(i+1);
		}
		dbl.traverseForward();
		dbl.insertAtPosition(5, 7);
		System.out.println();
		dbl.traverseForward();
		dbl.delete();
		System.out.println();
		dbl.traverseForward();
		System.out.println();
	}

}
