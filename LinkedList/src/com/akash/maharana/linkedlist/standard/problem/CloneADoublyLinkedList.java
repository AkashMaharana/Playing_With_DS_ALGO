package com.akash.maharana.linkedlist.standard.problem;

public class CloneADoublyLinkedList {
	
	//Using O(1) extra space
	
	public static void main(String[] args) {
		DoublyNode headNode=new DoublyNode(1);
		headNode.next=new DoublyNode(2);
		headNode.next.next=new DoublyNode(3);
		headNode.next.next.next=new DoublyNode(4);
		headNode.next.next.next.next=new DoublyNode(5);
		
		headNode.random=headNode.next.next;
		headNode.next.random=headNode;
		headNode.next.next.random=headNode.next.next.next.next;
		headNode.next.next.next.random=headNode.next.next.next.next;
		headNode.next.next.next.next.random=headNode.next;
		System.out.println("Original List");
		printList(headNode);
		DoublyNode finalNode=cloneList(headNode);
		System.out.println();
		System.out.println("Clone List");
		printList(finalNode);
	}
	
	private static void printList(DoublyNode node){
		while(node!=null){
			System.out.println("Data : "+node.data+" | Random : "+node.random.data);
			node=node.next;
		}
		System.out.println();
	}
	
	private static DoublyNode cloneList(DoublyNode node){
		DoublyNode currentNode=node;
		DoublyNode tempNode=null;
		while(currentNode!=null){
			tempNode=currentNode.next;
			currentNode.next=new DoublyNode(currentNode.data);
			currentNode.next.next=tempNode;
			currentNode=tempNode;
		}
		currentNode=node;
		while(currentNode!=null){
			currentNode.next.random=currentNode.random.next;
			if(currentNode.next!=null){
				currentNode=currentNode.next.next;
			}
			else{
				currentNode=currentNode.next;
			}
		}
		currentNode=node;
		DoublyNode copyNode=node.next;
		DoublyNode finalNode=copyNode;
		while(currentNode!=null && copyNode!=null){
			if(currentNode.next!=null && copyNode.next!=null){
				currentNode.next=currentNode.next.next;
				copyNode.next=copyNode.next.next;
				currentNode=currentNode.next;
				copyNode=copyNode.next;
			}
			else{
				currentNode=currentNode.next;
				copyNode=copyNode.next;
			}
		}
		return finalNode;
	}

}

class  DoublyNode{
	int data;
	DoublyNode next;
	DoublyNode random;
	
	DoublyNode(int data){
		this.data=data;
		this.next=null;
		this.random=null;
	}
}

