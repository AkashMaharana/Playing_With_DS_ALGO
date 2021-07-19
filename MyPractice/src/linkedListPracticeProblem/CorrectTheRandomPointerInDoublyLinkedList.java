package linkedListPracticeProblem;

public class CorrectTheRandomPointerInDoublyLinkedList {
	
	public static void main(String[] args) {
		DoublyLinkedListNode head=new DoublyLinkedListNode(1);
		head.next = new DoublyLinkedListNode(2); 
	    head.next.prev = head; 
	    head.next.next = new DoublyLinkedListNode(3); 
	    head.next.next.prev = head; 
	    head.next.next.next = new DoublyLinkedListNode(4); 
	    head.next.next.next.prev = head.next.next;
	    printList(head);
	    correctThePointer(head);
	    printList(head);
	}
	
	private static void correctThePointer(DoublyLinkedListNode head){
		if(head==null){
			return;
		}
		DoublyLinkedListNode tempNode=head;
		if(head.next!=null && head.next.prev!=head){
			head.next.prev=head;
			return;
		}
		if(head.prev!=null){
			head.prev=null;
			return;
		}
		tempNode=tempNode.next;
		while(tempNode!=null){
			if(tempNode.next!=null && tempNode.next.prev!=tempNode){
				tempNode.next.prev=tempNode;
				return;
			}
			else if(tempNode.prev!=null && tempNode.prev.next!=tempNode){
				tempNode.prev.next=tempNode;
				return;
			}
			tempNode=tempNode.next;
		}
		
	}
	
	private static void printList(DoublyLinkedListNode node){
		while(node!=null){
			System.out.println("Prev : "+(node.prev!=null?node.prev.data:-1)+"| Current : " +node.data+" | Next : "+
					(node.next!=null?node.next.data:-1));
			node=node.next;
		}
		System.out.println("--------------------------------------");
	}

}

class DoublyLinkedListNode{
	int data;
	DoublyLinkedListNode prev;
	DoublyLinkedListNode next;
	
	DoublyLinkedListNode(int data){
		this.data=data;
		this.prev=null;
		this.next=null;
	}
}

class DoublyLinkedListNodeImpl{
	
	public DoublyLinkedListNode insert(int data){
		DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
		return newNode;
	}
}