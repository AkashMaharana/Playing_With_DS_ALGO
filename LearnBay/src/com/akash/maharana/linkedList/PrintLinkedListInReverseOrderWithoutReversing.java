package com.akash.maharana.linkedList;

public class PrintLinkedListInReverseOrderWithoutReversing {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		printWithoutReverse(l.getRootNode());
	}
	
	private static void printWithoutReverse(Node node){
		Node rootNode=node;
		if(rootNode==null){
			return;
		}
		printWithoutReverse(node.getNextNode());
		System.out.print(node.getData()+"->");
		
	}

}
