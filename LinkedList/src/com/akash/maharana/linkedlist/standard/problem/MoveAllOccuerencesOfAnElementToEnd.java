package com.akash.maharana.linkedlist.standard.problem;

import com.akash.maharana.linkedlist.singly.impl.LinkedList;
import com.akash.maharana.linkedlist.singly.impl.Node;

public class MoveAllOccuerencesOfAnElementToEnd {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		list.addNode(4);
		list.addNode(3);
		list.addNode(2);
		printList(list.getRoootNode());
		moveAllOccurence(list.getRoootNode(),2);
		printList(list.getRoootNode());
	}

	private static void moveAllOccurence(Node node,int key) {
		Node slowPointer=node;
		Node fastPointer=node;
		Node beforeToSlowPointer=null;
		Node beforeToFirstPointer=null;
		Node fast=null;
		Node slow=null;
		Node fastToNext=null;
		Node slowToNext=null;
		while(fastPointer!=null){
			if(fastPointer.getData()==key){
				beforeToFirstPointer=fastPointer;
				fastPointer=fastPointer.getNextNode();
			}
			else{
				if(fastPointer.getData()!=slowPointer.getData()){
					fast=fastPointer;
					slow=slowPointer;
					fastToNext=fast.getNextNode();
					slowToNext=slow.getNextNode();
					beforeToSlowPointer.setNextNode(fastPointer);
					beforeToSlowPointer.getNextNode().setNextNode(slowToNext);
					beforeToFirstPointer.setNextNode(slowPointer);
					beforeToFirstPointer.getNextNode().setNextNode(fastToNext);
					beforeToSlowPointer=fast;
					slowPointer=beforeToSlowPointer.getNextNode();
					beforeToFirstPointer=slow;
					fastPointer=beforeToFirstPointer.getNextNode();
				}
				else{
					beforeToFirstPointer=fastPointer;
					fastPointer=fastPointer.getNextNode();
					beforeToSlowPointer=slowPointer;
					slowPointer=slowPointer.getNextNode();
				}
			}
		}
	}

	private static void printList(Node node) {
		while(node!=null){
			System.out.println(node.getData());
			node=node.getNextNode();
		}
		System.out.println();
	}
	
}
