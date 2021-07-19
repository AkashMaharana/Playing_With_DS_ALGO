package com.akash.maharana.linkedlist.standard.problem;

public class MergeTwoSortedLinkedList {
	
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		LinkedList l2=new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(6);
		l2.insert(4);
		l2.insert(5);
		Node newNode=mergeInSortedOrder(l1.getRootNode(),l2.getRootNode());
		while(newNode!=null){
			System.out.print(newNode.getData()+"->");
			newNode=newNode.getNextNode();
		}
	}
	
	private static Node mergeInSortedOrder(Node head1,Node head2){
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
			head1.setNextNode(mergeInSortedOrder(head1.getNextNode(), head2));
		}
		else{
			Node tempNode=head2;
			head2=head2.getNextNode();
			tempNode.setNextNode(head1);
			head1=tempNode;
			head1.setNextNode(mergeInSortedOrder(head1.getNextNode(), head2));
		}
		return head1;
	}	
}
