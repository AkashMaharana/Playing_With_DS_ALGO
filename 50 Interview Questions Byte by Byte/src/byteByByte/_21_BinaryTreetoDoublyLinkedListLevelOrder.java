package byteByByte;

import java.util.LinkedList;
import java.util.Queue;

public class _21_BinaryTreetoDoublyLinkedListLevelOrder {
	
	NodeLevelOrder root;
	NodeLevelOrder head;
	static NodeLevelOrder previous;
	
	public static void main(String[] args) {
		_21_BinaryTreetoDoublyLinkedListLevelOrder tree = new _21_BinaryTreetoDoublyLinkedListLevelOrder();
		tree.root = new NodeLevelOrder(10);
		tree.root.left = new NodeLevelOrder(12);
		tree.root.right = new NodeLevelOrder(15);
		tree.root.left.left = new NodeLevelOrder(25);
		tree.root.left.right = new NodeLevelOrder(30);
		tree.root.right.left = new NodeLevelOrder(36);
		tree.binaryTree2DoubleLinkedList(tree.root);
		tree.printList(tree.head);
	}
	
	private void binaryTree2DoubleLinkedList(NodeLevelOrder root) {
		if(root==null) {
			return;
		}
		Queue<NodeLevelOrder> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			NodeLevelOrder temp=q.poll();
			NodeLevelOrder newNode=new NodeLevelOrder(temp.data);
			if(head==null) {
				head=newNode;
			}
			else {
				newNode.left=previous;
				previous.right=newNode;
			}
			previous=newNode;
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
	}

	private void printList(NodeLevelOrder node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

}

class NodeLevelOrder {
	int data;
	NodeLevelOrder left;
	NodeLevelOrder right;

	NodeLevelOrder(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
