package linkedListPracticeProblem;

public class FlatteningALinkedList {
	
	public static void main(String[] args) {
		/* Let us create the following linked list 
        5 -> 10 -> 19 -> 28 
        |    |     |     | 
        V    V     V     V 
        7    20    22    35 
        |          |     | 
        V          V     V 
        8          50    40 
        |                | 
        V                V 
        30               45 
    */
		LinkedListFlatten l = new LinkedListFlatten();
		l.headNode = l.push(l.headNode, 30);
		l.headNode = l.push(l.headNode, 8);
		l.headNode = l.push(l.headNode, 7);
		l.headNode = l.push(l.headNode, 5);

		l.headNode.right = l.push(l.headNode.right, 20);
		l.headNode.right = l.push(l.headNode.right, 10);

		l.headNode.right.right = l.push(l.headNode.right.right, 50);
		l.headNode.right.right = l.push(l.headNode.right.right, 22);
		l.headNode.right.right = l.push(l.headNode.right.right, 19);

		l.headNode.right.right.right = l.push(l.headNode.right.right.right, 45);
		l.headNode.right.right.right = l.push(l.headNode.right.right.right, 40);
		l.headNode.right.right.right = l.push(l.headNode.right.right.right, 35);
		l.headNode.right.right.right = l.push(l.headNode.right.right.right, 20);

		l.flatten(l.headNode);
		l.printList();
	}

}

class FlattenNode {
	int data;
	FlattenNode right;
	FlattenNode down;

	public FlattenNode(int data) {
		this.data = data;
		this.right = null;
		this.down = null;
	}
}

class LinkedListFlatten {

	FlattenNode headNode;

	FlattenNode flatten(FlattenNode rootNode) {
		if(rootNode==null || rootNode.right==null){
			return rootNode;
		}
		else{
			rootNode.right=flatten(rootNode.right);
			rootNode=merge(rootNode,rootNode.right);
		}
		return rootNode;
	}
	
	FlattenNode merge(FlattenNode head1,FlattenNode head2){
		if(head1==null && head2==null){
			return null;
		}
		else if(head1==null){
			return head2;
		}
		else if(head2==null){
			return head1;
		}
		if(head1.data<head2.data){
			head1.down=merge(head1.down,head2);
		}
		else{
			FlattenNode temp=head2;
			head2=head2.down;
			temp.down=head1;
			head1=temp;
			head1.down=merge(head1.down,head2);
		}
		return head1;
	}

	FlattenNode push(FlattenNode rootNode, int data) {
		FlattenNode newNode = new FlattenNode(data);
		newNode.down = rootNode;
		rootNode = newNode;
		return rootNode;
	}

	void printList() {
		FlattenNode tempHead = this.headNode;
		while (tempHead != null) {
			System.out.print(tempHead.data + "->");
			tempHead = tempHead.down;
		}
		System.out.println();
	}

}