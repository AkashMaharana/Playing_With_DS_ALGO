package com.akash.maharana;

public class LinkedListHelper {
	
	public static void traverseList(LinkedListNode node) {
		while(node!=null) {
			System.out.print(node.getData()+" ");
			node=node.getNext();
		}
		System.out.println();
	}

}
