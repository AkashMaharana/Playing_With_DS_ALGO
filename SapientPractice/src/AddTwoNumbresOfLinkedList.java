
public class AddTwoNumbresOfLinkedList {
	
	public static void main(String[] args) {
		LinkedList list1=new LinkedList();
		list1.addNode(7);
		list1.addNode(5);
		list1.addNode(9);
		list1.addNode(4);
		list1.addNode(6);
		LinkedList list2=new LinkedList();
		list2.addNode(8);
		list2.addNode(4);
		addTwoNumbers(list1.root,list2.root);
	}
	
	private static Node addTwoNumbers(Node head1,Node head2) {
		LinkedList list=new LinkedList();
		int sum=0;
		int valueToAdd=0;
		int carry=0;
		while(head1!=null && head2!=null) {
			sum=head1.data+head2.data+carry;
			if(sum>9) {
				valueToAdd=sum-10;
				list.addNode(valueToAdd);
				carry=1;
				head1=head1.nextNode;
				head2=head2.nextNode;
			}
			else {
				list.addNode(sum);
				head1=head1.nextNode;
				head2=head2.nextNode;
				carry=0;
			}
		}
		while(head1!=null) {
			sum=head1.data+carry;
			if(sum>9) {
				valueToAdd=sum-10;
				list.addNode(valueToAdd);
				carry=1;
				head1=head1.nextNode;
			}
			else {
				list.addNode(sum);
				head1=head1.nextNode;
				carry=0;
			}
		}
		while(head2!=null) {
			sum=head2.data+carry;
			if(sum>9) {
				valueToAdd=sum-10;
				list.addNode(valueToAdd);
				carry=1;
				head2=head2.nextNode;
			}
			else {
				list.addNode(sum);
				head2=head2.nextNode;
				carry=0;
			}
		}
		Node root=list.root;
		while(root!=null) {
			System.out.print(root.data+" ");
			root=root.nextNode;
		}
		return null;
	}

}

class LinkedList{
	
	public Node root=null;
	
	public void addNode(int data) {
		if(root==null) {
			this.root=new Node(data);
		}
		else {
			Node temp=this.root;
			while(temp.nextNode!=null) {
				temp=temp.nextNode;
			}
			temp.nextNode=new Node(data);
		}
	}
}
