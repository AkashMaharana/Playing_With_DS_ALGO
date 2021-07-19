package com.akash.maharana;

public class _12_IntersectionOfTwoLinkedList {
	
	public static void main(String[] args) {
		LinkedListNode head1=new LinkedListNode(3);
		head1.setNext(new LinkedListNode(6));
		head1.getNext().setNext(new LinkedListNode(9));
		head1.getNext().getNext().setNext(new LinkedListNode(15));
		head1.getNext().getNext().getNext().setNext(new LinkedListNode(30));
		
		LinkedListNode head2=new LinkedListNode(10);
		head2.setNext(head1.getNext().getNext().getNext());
		
		System.out.println("Intersection Point : "+intersectionPoint(head1,head2));
		
		LinkedListHelper.traverseList(head1);
		LinkedListHelper.traverseList(head2);
		
	}
	
	private static int intersectionPoint(LinkedListNode head1,LinkedListNode head2) {
		LinkedListNode tempHead2=head2;
		while(head2.getNext()!=null) {
			head2=head2.getNext();
		}
		head2.setNext(tempHead2);
		LinkedListNode slowPointer=head1;
		LinkedListNode firstPointer=head1;
		while(slowPointer!=null && firstPointer!=null && firstPointer.getNext()!=null) {
			slowPointer=slowPointer.getNext();
			firstPointer=firstPointer.getNext().getNext();
			if(slowPointer==firstPointer) {
				break;
			}
		}
		slowPointer=head1;
		while(slowPointer!=null && firstPointer!=null) {
			if(slowPointer==firstPointer) {
				break;
			}
			else {
				slowPointer=slowPointer.getNext();
				firstPointer=firstPointer.getNext();
			}
		}
		while(firstPointer.getNext()!=null) {
			if(firstPointer.getNext()==tempHead2) {
				firstPointer.setNext(null);
				break;
			}
			firstPointer=firstPointer.getNext();
		}
		return slowPointer.getData();
	}

}
