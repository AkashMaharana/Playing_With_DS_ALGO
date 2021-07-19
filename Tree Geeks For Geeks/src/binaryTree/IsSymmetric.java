package binaryTree;

import java.util.Queue;
import java.util.LinkedList;

public class IsSymmetric {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(2));
		rootNode.getLeftChild().setLeftChild(new Node(3));
		rootNode.getLeftChild().setRightChild(new Node(4));
		rootNode.getRightChild().setLeftChild(new Node(4));
		rootNode.getRightChild().setRightChild(new Node(3));
		System.out.println(isSymmetric(rootNode));
	}
	
	private static boolean isSymmetric(Node node){
		//return isMirrorRecursive(node,node);
		return isMirrorIterative(node);
	}
	
	/*private static boolean isMirrorRecursive(Node node1,Node node2){
		if(node1==null && node2==null){
			return true;
		}
		if(node1!=null && node2!=null && node1.getData()==node2.getData()){
			return (isMirrorRecursive(node1.getLeftChild(), node2.getRightChild()) && isMirrorRecursive(node2.getLeftChild(),node1.getRightChild()));
		}
		return false;
	}*/
	
	private static boolean isMirrorIterative(Node node){
		if(node==null){
			return false;
		}
		Queue<Node> q=new LinkedList<>();
		q.add(node.getLeftChild());
		q.add(node.getRightChild());
		while(!q.isEmpty()){
			Node tempLeft=q.poll();
			Node tempRight=q.poll();
			if(tempLeft==null && tempRight==null){
				return true;
			}
			if((tempLeft!=null && tempRight==null) || (tempLeft==null && tempRight!=null) || (tempLeft.getData()!=tempRight.getData())){
				return false;
			}
			q.add(tempLeft.getLeftChild());
			q.add(tempRight.getRightChild());
			q.add(tempLeft.getRightChild());
			q.add(tempRight.getLeftChild());
		}
		return false;
 	}

}
