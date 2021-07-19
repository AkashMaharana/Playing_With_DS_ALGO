package com.akash.maharana.linkedlist.standard.problem;

public class MergeKSortedLinkedList {

	public static void main(String args[]) {
		int k = 3; // Number of linked lists

		MergeNode1 arr[] = new MergeNode1[k];

		arr[0] = new MergeNode1(1);
		arr[0].next = new MergeNode1(3);
		arr[0].next.next = new MergeNode1(5);
		arr[0].next.next.next = new MergeNode1(7);

		arr[1] = new MergeNode1(2);
		arr[1].next = new MergeNode1(4);
		arr[1].next.next = new MergeNode1(6);
		arr[1].next.next.next = new MergeNode1(8);

		arr[2] = new MergeNode1(0);
		arr[2].next = new MergeNode1(9);
		arr[2].next.next = new MergeNode1(10);
		arr[2].next.next.next = new MergeNode1(11);

		MergeNode1 head = mergeKLists(arr, k - 1);
		printList(head);
	}

	private static void printList(MergeNode1 node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	private static MergeNode1 mergeKLists(MergeNode1[] arr, int last) {
		while (last != 0) {
			int i = 0;
			int j = last;
			while (i < j) {
				arr[i] = mergeTwoList(arr[i], arr[j]);
				i++;
				j--;
				if (i >= j) {
					last = j;
				}
			}
		}
		return arr[0];
	}

	private static MergeNode1 mergeTwoList(MergeNode1 head1, MergeNode1 head2) {
		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		if (head1.data < head2.data) {
			head1.next = mergeTwoList(head1.next, head2);
		} else {
			MergeNode1 tempNode = head2;
			head2 = head2.next;
			tempNode.next = head1;
			head1 = tempNode;
			head1.next = mergeTwoList(head1.next, head2);
		}
		return head1;
	}

}

class MergeNode1 {
	int data;
	MergeNode1 next;

	public MergeNode1(int data) {
		this.data = data;
	}
}