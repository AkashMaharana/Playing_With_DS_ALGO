package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertIntoBinaryTreeLevelOrder {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		//rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		insertIntoBinaryTree(rootNode,9);
	}
	
	private static void insertIntoBinaryTree(Node node,int data){
		if(node==null){
			return;
		}
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		int count=0;
		while(!q.isEmpty()){
			Node tempNode=q.poll();
			System.out.print(tempNode.getData()+" ");
			if(tempNode.getLeftChild()!=null){
				q.add(tempNode.getLeftChild());
			}
			if(tempNode.getRightChild()!=null){
				q.add(tempNode.getRightChild());
			}
			if(tempNode.getLeftChild()==null && count==0){
				tempNode.setLeftChild(new Node(data));
				q.add(tempNode.getLeftChild());
				count=1;
			}
			if(tempNode.getRightChild()==null && count==0){
				tempNode.setRightChild(new Node(data));
				q.add(tempNode.getRightChild());
				count=1;
			}
		}
	}

}
