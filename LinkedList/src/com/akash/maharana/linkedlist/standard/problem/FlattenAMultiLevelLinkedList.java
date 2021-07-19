package com.akash.maharana.linkedlist.standard.problem;

class FlattenAMultiLevelLinkedList {

	static Node1 head;

	private Node1 createList(int arr[], int n) {
		Node1 node = null;
		Node1 p = null;
		int i;
		for (i = 0; i < n; ++i) {
			if (node == null) {
				node = p = new Node1(arr[i]);
			} else {
				p.next = new Node1(arr[i]);
				p = p.next;
			}
			p.next = p.child = null;
		}
		return node;
	}

	private void printList(Node1 node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}

	private Node1 createList() {
		int arr1[] = new int[] { 10, 5, 12, 7, 11 };
		int arr2[] = new int[] { 4, 20, 13 };
		int arr3[] = new int[] { 17, 6 };
		int arr4[] = new int[] { 9, 8 };
		int arr5[] = new int[] { 19, 15 };
		int arr6[] = new int[] { 2 };
		int arr7[] = new int[] { 16 };
		int arr8[] = new int[] { 3 };

		Node1 head1 = createList(arr1, arr1.length);
		Node1 head2 = createList(arr2, arr2.length);
		Node1 head3 = createList(arr3, arr3.length);
		Node1 head4 = createList(arr4, arr4.length);
		Node1 head5 = createList(arr5, arr5.length);
		Node1 head6 = createList(arr6, arr6.length);
		Node1 head7 = createList(arr7, arr7.length);
		Node1 head8 = createList(arr8, arr8.length);

		head1.child = head2;
		head1.next.next.next.child = head3;
		head3.child = head4;
		head4.child = head5;
		head2.next.child = head6;
		head2.next.next.child = head7;
		head7.child = head8;

		return head1;
	}

	private void flattenList(Node1 node) {
		if(node==null){
			return;
		}
		Node1 temp=null;
		Node1 tail=node;
		while(tail.next!=null){
			tail=tail.next;
		}
		Node1 current=node;
		while(current!=tail){
			if(current.child!=null){
				tail.next=current.child;
				temp=current.child;
				while(temp.next!=null){
					temp=temp.next;
				}
				tail=temp;
			}
			current=current.next;
		}
	}

	public static void main(String[] args) {
		FlattenAMultiLevelLinkedList list = new FlattenAMultiLevelLinkedList();
		head = list.createList();
		list.flattenList(head);
		list.printList(head);
	}
}

class Node1 {

	int data;
	Node1 next, child;

	Node1(int d) {
		data = d;
		next = child = null;
	}
}
