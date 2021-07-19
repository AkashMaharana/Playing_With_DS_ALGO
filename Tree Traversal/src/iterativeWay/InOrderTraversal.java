package iterativeWay;

import java.util.Stack;

public class InOrderTraversal {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		inOrderTraversalIterativeWay(rootNode);
	}
	
	private static void inOrderTraversalIterativeWay(Node node){
		if(node==null){
			return;
		}
		Stack<Node> s=new Stack<>();
		Node currentNode=node;
		while(currentNode!=null || s.size()>0){
			while(currentNode!=null){
				s.push(currentNode);
				currentNode=currentNode.getLeftChild();
			}
			currentNode=s.pop();
			System.out.print(currentNode.getData()+" ");
			currentNode=currentNode.getRightChild();
		}
	}

}
