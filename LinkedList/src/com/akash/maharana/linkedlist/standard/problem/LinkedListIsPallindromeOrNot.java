package com.akash.maharana.linkedlist.standard.problem;

public class LinkedListIsPallindromeOrNot {
	
	public static void main(String[] args) {
		SinglyLinkedList l=new SinglyLinkedList();
		l.insertNode(10);
		l.insertNode(20);
		/*l.insertNode(20);
		l.insertNode(30);
		l.insertNode(20);
		l.insertNode(10);*/
		System.out.println(l.checkPallindrome());
	}

}

class SinglyLinkedListNode{
	
	SinglyLinkedListNode next;
	int data;
	
	
	public SinglyLinkedListNode(int data){
		this.data=data;
		this.next=null;
	}
}

class SinglyLinkedList{
	
	SinglyLinkedListNode head;
	SinglyLinkedListNode tail;
	
	public SinglyLinkedList(){
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
	
	public boolean checkPallindrome(){
		boolean isPallindrome=true;
		SinglyLinkedListNode fastPointer=head;
		SinglyLinkedListNode slowPointer=head;
		SinglyLinkedListNode midNode=null;
		SinglyLinkedListNode previousOfSlowPointer=head;
		SinglyLinkedListNode secondHalfNode=null;
		if(head!=null && head.next!=null){
			while(fastPointer!=null && fastPointer.next!=null){
				fastPointer=fastPointer.next.next;
				previousOfSlowPointer=slowPointer;
				slowPointer=slowPointer.next;
			}
			if(fastPointer!=null){
				midNode=slowPointer;
				slowPointer=slowPointer.next;
			}
			secondHalfNode=slowPointer;
			previousOfSlowPointer.next=null;
			SinglyLinkedListNode tempNode=reverse(slowPointer);
			isPallindrome=compareList(this.head, tempNode);
			reverse(tempNode);
			if(midNode!=null){
				previousOfSlowPointer.next=midNode;
				midNode.next=secondHalfNode;
			}
			else{
				previousOfSlowPointer.next=secondHalfNode;
			}
		}
		return isPallindrome;
	}
	
	public boolean compareList(SinglyLinkedListNode head1,SinglyLinkedListNode head2){
		boolean isValid=false;
		SinglyLinkedListNode temp1=head1;
		SinglyLinkedListNode temp2=head2;
		while(temp1!=null && temp2!=null){
			if(temp1.data==temp2.data){
				temp1=temp1.next;
				temp2=temp2.next;
			}
			else{
				return isValid;
			}
		}
		if(temp1==null && temp2==null){
			return true;
		}
		isValid=true;
		
		return isValid;
	}
	
	public SinglyLinkedListNode reverse(SinglyLinkedListNode node){
		SinglyLinkedListNode head=node;
		SinglyLinkedListNode nextToHead=node.next;
		if(head==null || nextToHead==null){
			return head;
		}
		SinglyLinkedListNode tempNode=reverse(nextToHead);
		head.next.next=head;
		head.next=null;
		return tempNode;
	}
}
