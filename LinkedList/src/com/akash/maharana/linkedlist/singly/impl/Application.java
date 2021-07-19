package com.akash.maharana.linkedlist.singly.impl;

public class Application {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.traverseList();
		System.out.println("Size : "+list.size());
		list.deleteNode(50);
		list.traverseList();
		System.out.println("Size : "+list.size());
	}

}
