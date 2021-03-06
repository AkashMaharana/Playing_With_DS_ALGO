package com.akash.maharana.linkedlist.standard.problem;

public class SegregateEvenAndOddNodesOfLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList1 l=new SinglyLinkedList1();
		l.insertNode(17);
		l.insertNode(15);
		l.insertNode(8);
		l.insertNode(12);
		l.insertNode(10);
		l.insertNode(5);
		l.insertNode(4);
		l.insertNode(1);
		l.insertNode(7);
		l.insertNode(6);
		l.traverseList();
		System.out.println();
		l.rearrangeList(l);
		l.traverseList();
	}
}

class SinglyLinkedListNode1{
	
	SinglyLinkedListNode next;
	int data;
	
	
	public SinglyLinkedListNode1(int data){
		this.data=data;
		this.next=null;
	}
}

class SinglyLinkedList1{
	
	SinglyLinkedListNode head;
	SinglyLinkedListNode tail;
	
	public SinglyLinkedList1(){
		this.head=null;
		this.tail=null;
	}
	
	public void insertNode(int data){
		SinglyLinkedListNode newNode=new SinglyLinkedListNode(data);;
		if(this.head==null){
			this.head=newNode;
		}
		else{
			this.tail.next=newNode;
		}
		this.tail=newNode;
	}
	
	public void traverseList(){
		if(this.head==null){
			return;
		}
		else{
			SinglyLinkedListNode node=this.head;
			while(node!=null){
				System.out.print(node.data+"->");
				node=node.next;
			}
		}
	}
	
	public void rearrangeList(SinglyLinkedList1 l){
		SinglyLinkedListNode tempNode=reverse(this.head);
		SinglyLinkedListNode lastEvenNode=null;
		SinglyLinkedListNode previousNode=null;
		while(tempNode!=null){
			if(tempNode.data%2==0){
				if(lastEvenNode==null){
					lastEvenNode=tempNode;
					previousNode=tempNode;
					tempNode=tempNode.next;
				}
				else{
					previousNode=tempNode;
					tempNode=tempNode.next;
				}
			}
			else{
				if(tempNode==head){
					previousNode=tempNode;
					tempNode=tempNode.next;
				}
				else{
					if(lastEvenNode!=null){
						SinglyLinkedListNode  newInsertionNode=tempNode;
						previousNode.next=tempNode.next;
						newInsertionNode.next=lastEvenNode;
						lastEvenNode.next=newInsertionNode;
						tempNode=previousNode;
					}
					else{
						previousNode=tempNode;
						tempNode=tempNode.next;
					}
				}
			}
		}
		SinglyLinkedListNode finalHead=reverse(tempNode);
		this.head=finalHead;
	}
	
	public SinglyLinkedListNode reverse(SinglyLinkedListNode node){
		SinglyLinkedListNode head=node;
		SinglyLinkedListNode nextToHead=node.next;
		if(head==null || head.next==null){
			return head;
		}
		SinglyLinkedListNode tempNode=reverse(nextToHead);
		head.next.next=head;
		head.next=null;
		return tempNode;
	}
}	


