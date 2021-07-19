package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class SortALinkedListUsingMergeSort {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addNode(2);
		list.addNode(9);
		list.addNode(-2);
		list.addNode(3);
		list.addNode(78);
		list.addNode(13);
		list.addNode(5);
		list.addNode(31);
		printList(list.getRoootNode());
		Node node=sortList(list.getRoootNode());
		printList(node);
	}
	
	private static void printList(Node node){
		while(node!=null){
			System.out.print(node.getData()+"->");
			node=node.getNextNode();
		}
		System.out.println();
	}
	
	private static Node sortList(Node node){
		if(node==null || node.getNextNode()==null){
			return node;
		}
		Node midNode=getMiddle(node);
		Node nextToMidNode=midNode.getNextNode();
		midNode.setNextNode(null);
		Node leftNode=sortList(node);
		Node rightNode=sortList(nextToMidNode);
		Node mergeNode=mergeList(leftNode,rightNode);
		return mergeNode;
	}
	
	private static Node mergeList(Node head1,Node head2){
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
			head1.setNextNode(mergeList(head1.getNextNode(),head2));
		}
		else{
			Node tempNode=head2;
			head2=head2.getNextNode();
			tempNode.setNextNode(head1);
			head1=tempNode;
			head1.setNextNode(mergeList(head1.getNextNode(),head2));
		}
		return head1;
	}
	
	private static Node getMiddle(Node node){
		if(node==null){
			return null;
		}
		Node fastPointer=node;
		Node slowPointer=node;
		while(fastPointer.getNextNode()!=null && fastPointer.getNextNode().getNextNode()!=null){
			fastPointer=fastPointer.getNextNode().getNextNode();
			slowPointer=slowPointer.getNextNode();
		}
		return slowPointer;
	}

}
