package linkedListPracticeProblem;

public class CloneALinkedListWithNextAndRandomPointer {
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
		DoublyNode originalNode=node;
		DoublyNode temp=null;
		while(originalNode!=null){
			temp=originalNode.next;
			originalNode.next=new DoublyNode(originalNode.data);
			originalNode.next.next=temp;
			originalNode=temp;
		}
		originalNode=node;
		while(originalNode!=null){
			originalNode.next.random=originalNode.random.next;
			if(originalNode.next!=null){
				originalNode=originalNode.next.next;
			}
			else{
				originalNode=originalNode.next;
			}
		}
		originalNode=node;
		DoublyNode actualNode=node;
		DoublyNode copyNode=node.next;
		DoublyNode finalNode=copyNode;
		while(actualNode!=null && copyNode!=null){
			if(actualNode.next!=null && copyNode.next!=null){
				actualNode.next=actualNode.next.next;
				copyNode.next=copyNode.next.next;
				actualNode=actualNode.next;
				copyNode=copyNode.next;
			}
			else{
				actualNode=actualNode.next;
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
