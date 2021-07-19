package linkedList;

public class LinkedList{
	
	public Node root;
	
	public void add(int data) {
		if(root==null) {
			root=new Node(data);
		}
		else {
			Node temp=root;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=new Node(data);
		}
	}
	
	public void traverse(Node node) {
		Node temp=node;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}

class Node {
	
	public int data;
	public Node next;
	
	public Node(int data) {
		this.data=data;
		this.next=null;
	}

}
