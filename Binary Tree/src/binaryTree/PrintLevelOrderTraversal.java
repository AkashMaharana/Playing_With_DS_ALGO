package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTraversal {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		
		printLevelOrderTraversal(rootNode);
		System.out.println();
		System.out.println();
		printLineByLineLevel(rootNode);
	}
	
	
	private static void printLevelOrderTraversal(Node node){
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			Node tempNode=q.poll();
			System.out.print(tempNode.getData()+"->");
			if(tempNode.getLeftChild()!=null){
				q.add(tempNode.getLeftChild());
			}
			if(tempNode.getRightChild()!=null){
				q.add(tempNode.getRightChild());
			}
		}
	}
	
	private static void printLineByLineLevel(Node node){
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		q.add(null);
		while(!q.isEmpty()){
			Node tempNode=q.poll();
			if(tempNode==null){
				if(!q.isEmpty()){
					q.add(null);
					System.out.println();
				}
			}
			else{
				if(tempNode.getLeftChild()!=null){
					q.add(tempNode.getLeftChild());
				}
				if(tempNode.getRightChild()!=null){
					q.add(tempNode.getRightChild());
				}
				System.out.print(tempNode.getData()+" ");
			}
		}
	}

}
