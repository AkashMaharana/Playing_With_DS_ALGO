package com.akash.maharana.linkedlist.standard.problem;

import com.akash.maharana.linkedlist.singly.impl.LinkedList;
import com.akash.maharana.linkedlist.singly.impl.Node;

public class UnionIntersectionofTwoLinkedList {
	
	public static void main(String[] args) {
		LinkedList list1=new LinkedList();
		list1.addNode(1);
		list1.addNode(3);
		list1.addNode(4);
		list1.addNode(5);
		list1.addNode(7);
		LinkedList list2=new LinkedList();
		list2.addNode(2);
		list2.addNode(3);
		list2.addNode(5);
		list2.addNode(6);
		list2.addNode(7);
		Node unionNode=unionOfTwoList(list1.getRoootNode(),list2.getRoootNode());
		System.out.print("Union List : ");
		printList(unionNode);
		Node intersectionNode=intersectionOfTwoList(list1.getRoootNode(), list2.getRoootNode());
		System.out.print("Intersection List : ");
		printList(intersectionNode);
	} 
	
	private static void printList(Node node){
		while(node!=null){
			System.out.print(node.getData()+"->");
			node=node.getNextNode();
		}
		System.out.println();
	}

	private static Node unionOfTwoList(Node head1, Node head2) {
		if(head1==null && head2==null){
			return null;
		}
		Node headAfterSort1=mergeSort(head1);
		Node headAfterSort2=mergeSort(head2);
		LinkedList newList=new LinkedList();
		while(headAfterSort1!=null && headAfterSort2!=null){
			if(headAfterSort1.getData()==headAfterSort2.getData()){
				newList.addNode(headAfterSort1.getData());
				headAfterSort1=headAfterSort1.getNextNode();
				headAfterSort2=headAfterSort2.getNextNode();
			}
			else if(headAfterSort1.getData()<headAfterSort2.getData()){
				newList.addNode(headAfterSort1.getData());
				headAfterSort1=headAfterSort1.getNextNode();
			}
			else if(headAfterSort2.getData()<headAfterSort1.getData()){
				newList.addNode(headAfterSort2.getData());
				headAfterSort2=headAfterSort2.getNextNode();
			}
		}
		if(headAfterSort1!=null){
			while(headAfterSort1!=null){
				newList.addNode(headAfterSort1.getData());
				headAfterSort1=headAfterSort1.getNextNode();
			}
		}
		else{
			while(headAfterSort2!=null){
				newList.addNode(headAfterSort2.getData());
				headAfterSort2=headAfterSort2.getNextNode();
			}
		}
		return newList.getRoootNode();
	}
	
	private static Node intersectionOfTwoList(Node head1,Node head2){
		if(head1==null && head2==null){
			return null;
		}
		Node headAfterSort1=mergeSort(head1);
		Node headAfterSort2=mergeSort(head2);
		LinkedList newList=new LinkedList();
		while(headAfterSort1!=null && headAfterSort2!=null){
			if(headAfterSort1.getData()==headAfterSort2.getData()){
				newList.addNode(headAfterSort1.getData());
				headAfterSort1=headAfterSort1.getNextNode();
				headAfterSort2=headAfterSort2.getNextNode();
			}
			else if(headAfterSort1.getData()<headAfterSort2.getData()){
				headAfterSort1=headAfterSort1.getNextNode();
			}
			else if(headAfterSort2.getData()<headAfterSort1.getData()){
				headAfterSort2=headAfterSort2.getNextNode();
			}
		}
		return newList.getRoootNode();
	}
	
	private static Node mergeSort(Node node){
		if(node==null || node.getNextNode()==null){
			return node;
		}
		Node middleNode=middleNode(node);
		Node nextToMiddle=middleNode.getNextNode();
		middleNode.setNextNode(null);
		Node leftNode=mergeSort(node);
		Node rightNode=mergeSort(nextToMiddle);
		Node mergeNode=merge(leftNode,rightNode);
		return mergeNode;
	}
	
	private static Node merge(Node head1,Node head2){
		if(head1==null && head2==null){
			return null;
		}
		else if(head1==null){
			return head2;
		}
		else if(head2==null){
			return head1;
		}
		if(head1.getData()<head2.getData()){
			head1.setNextNode(merge(head1.getNextNode(),head2));
		}
		else{
			Node tempNode=head2;
			head2=head2.getNextNode();
			tempNode.setNextNode(head1);
			head1=tempNode;
			head1.setNextNode(merge(head1.getNextNode(),head2));
		}
		return head1;
	}
	
	private static Node middleNode(Node node){
		if(node==null){
			return null;
		}
		Node slowPointer=node;
		Node fastPointer=node;
		while(fastPointer.getNextNode()!=null && fastPointer.getNextNode().getNextNode()!=null){
			slowPointer=slowPointer.getNextNode();
			fastPointer=fastPointer.getNextNode().getNextNode();
		}
		return slowPointer;
	}

}
