package linkedList;

public class MiddleElementOfALinkedList {
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		System.out.println("Middel element of linked list is : "+getMiddle(list.root));
	}
	
	private static int getMiddle(Node node) {
		Node slowPointer=node;
		Node fastPointer=node;
		while(fastPointer.next!=null && fastPointer.next.next!=null) {
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
		}
		if(fastPointer.next!=null) {
			return slowPointer.next.data;
		}
		return slowPointer.data;
	}

}
