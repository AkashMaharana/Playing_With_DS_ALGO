package geeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElementOfATree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(10));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(9));
		System.out.println(maxElement(rootNode));
		maxElementIterative(rootNode);
	}
	
	private static int maxElement(Node node){
		int i=maxElementRecursive(node,node.getData());
		if(i>node.getData()){
			return i;
		}
		else{
			return node.getData();
		}
	}
	
	private static int maxElementRecursive(Node node,int maxElement){
		if(node==null){
			return maxElement;
		}
		if(node.getData()>maxElement){
			maxElement=node.getData();
		}
		int leftmax=maxElementRecursive(node.getLeftChild(),maxElement);
		int rightMax=maxElementRecursive(node.getRightChild(),maxElement);
		if(leftmax>rightMax){
			return leftmax;
		}
		else{
			return rightMax;
		}
	}
	
	private static void maxElementIterative(Node node){
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		int max=node.getData();
		while(!q.isEmpty()){
			Node tempNode=q.poll();
			if(tempNode.getData()>max){
				max=tempNode.getData();
			}
			if(tempNode.getLeftChild()!=null){
				q.add(tempNode.getLeftChild());
			}
			if(tempNode.getRightChild()!=null){
				q.add(tempNode.getRightChild());
			}
		}
		System.out.println(max);
	}

}
