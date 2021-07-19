package linkedListPracticeProblem;

import singlyLinkedList.LinkedList;
import singlyLinkedList.Node;

public class MergeTwoSortedLinkedList {
	
	public static void main(String[] args) {
		LinkedList list1=new LinkedList();
		LinkedList list2=new LinkedList();
		list1.addNode(5);
		list1.addNode(10);
		list1.addNode(15);
		list1.addNode(40);
		list2.addNode(2);
		list2.addNode(3);
		list2.addNode(20);
		Node node=mergeTwoLists(list1.getRoootNode(),list2.getRoootNode());
		printList(node);
	}
	
	private static void printList(Node node){
		while(node!=null){
			System.out.println(node.getData());
			node=node.getNextNode();
		}
		System.out.println();
	}
	
	private static Node mergeTwoLists(Node node1,Node node2){
		if(node1==null && node2==null){
			return null;
		}
		else if(node1==null){
			return node2;
		}
		else if(node2==null){
			return node1;
		}
		if(node1.getData()<node2.getData()){
			node1.setNextNode(mergeTwoLists(node1.getNextNode(), node2));
		}
		else{
			Node tempNode=node2;
			node2=node2.getNextNode();
			tempNode.setNextNode(node1);
			node1=tempNode;
			node1.setNextNode(mergeTwoLists(node1.getNextNode(), node2));
		}
		return node1;
	}

}
