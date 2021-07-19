package com.akash.maharana.linkedlist.standard.problem;

import com.akash.maharana.linkedlist.doubly.impl.DoublyLinkedList;
import com.akash.maharana.linkedlist.doubly.impl.Node;

public class FindPairsWithGivenSumInDoublyLinkedList {
	
	public static void main(String[] args) {
		DoublyLinkedList l=new DoublyLinkedList();
		l.insert(1);
		l.insert(2);
		l.insert(4);
		l.insert(5);
		l.insert(6);
		l.insert(8);
		l.insert(9);
		findPairsWithGivenSumInDoublyLinkedList(l.rootNode,50);
	}

	private static void findPairsWithGivenSumInDoublyLinkedList(Node rootNode,int pairSum) {
		boolean isFound=false;
		Node firstNode=rootNode;
		Node secondNode=rootNode;
		while(secondNode.getNext()!=null){
			secondNode=secondNode.getNext();
		}
		while(firstNode!=null && secondNode!=null && firstNode!=secondNode && secondNode.getNext()!=firstNode){
			if(firstNode.getData()+secondNode.getData()==pairSum){
				System.out.println("("+firstNode.getData()+","+secondNode.getData()+")");
				isFound=true;
				firstNode=firstNode.getNext();
				secondNode=secondNode.getPrev();
			}
			else if(firstNode.getData()+secondNode.getData()<pairSum){
				firstNode=firstNode.getNext();
			}
			else{
				secondNode=secondNode.getPrev();
			}
		}
		if(!isFound){
			System.out.println("No Pair found");
		}
	}
}
