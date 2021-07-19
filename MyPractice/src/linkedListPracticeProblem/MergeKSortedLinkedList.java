package linkedListPracticeProblem;

public class MergeKSortedLinkedList {

	public static void main(String args[]) {
		int k = 3; // Number of linked lists

		MergeNode arr[] = new MergeNode[k];

		arr[0] = new MergeNode(1);
		arr[0].next = new MergeNode(3);
		arr[0].next.next = new MergeNode(5);
		arr[0].next.next.next = new MergeNode(7);

		arr[1] = new MergeNode(2);
		arr[1].next = new MergeNode(4);
		arr[1].next.next = new MergeNode(6);
		arr[1].next.next.next = new MergeNode(8);

		arr[2] = new MergeNode(0);
		arr[2].next = new MergeNode(9);
		arr[2].next.next = new MergeNode(10);
		arr[2].next.next.next = new MergeNode(11);

		MergeNode head = mergeKLists(arr, k - 1);
		printList(head);
	}

	private static void printList(MergeNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	private static MergeNode mergeKLists(MergeNode[] arr, int last) {
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

	private static MergeNode mergeTwoList(MergeNode head1, MergeNode head2) {
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
			MergeNode tempNode = head2;
			head2 = head2.next;
			tempNode.next = head1;
			head1 = tempNode;
			head1.next = mergeTwoList(head1.next, head2);
		}
		return head1;
	}

}

class MergeNode {
	int data;
	MergeNode next;

	public MergeNode(int data) {
		this.data = data;
	}
}