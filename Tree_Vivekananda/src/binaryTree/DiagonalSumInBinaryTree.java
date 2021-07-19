package binaryTree;

import java.util.Queue;
import java.util.LinkedList;

public class DiagonalSumInBinaryTree {
	
	public static void main(String[] args) {
		Node rootNode1=new Node(48);
		rootNode1.setLeftChild(new Node(33));
		rootNode1.setRightChild(new Node(15));
		rootNode1.getLeftChild().setLeftChild(new Node(16));
		rootNode1.getLeftChild().setRightChild(new Node(17));
		diagonalSum(rootNode1);
	}
	
	private static void diagonalSum(Node node){
		if(node==null){
			return;
		}
		Queue<Node> q=new LinkedList<>();
		int sum=0;
		q.add(node);
		q.add(null);
		while(!q.isEmpty()){
			Node tempNode=q.poll();
			if(tempNode==null){
				System.out.println(sum);
				sum=0;
				q.add(null);
				Node tNode=q.poll();
				if(tNode==null){
					break;
				}
				else{
					tempNode=tNode;
				}
			}
			while(tempNode!=null){
				if(tempNode.getLeftChild()!=null){
					q.add(tempNode.getLeftChild());
				}
				sum=sum+tempNode.getData();
				tempNode=tempNode.getRightChild();
			}
		}
	}

}
