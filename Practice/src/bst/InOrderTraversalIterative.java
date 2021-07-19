package bst;

import java.util.Stack;import java.util.concurrent.ConcurrentHashMap;

public class InOrderTraversalIterative {
	
	public static void main(String[] args) {
		BSTImpl bst=new BSTImpl();
		bst.insert(10);
		bst.insert(20);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(-9);
		//bst.traverse();
		Stack<Node> s=new Stack<>();
		//printINIterativeWay(bst.getRootNode(),s);
		System.out.println(count(bst.getRootNode()));
		System.out.println(counthalfNode(bst.getRootNode()));
	}
	
	private static void printINIterativeWay(Node node,Stack<Node> s){
		while(node.getLeftChild()!=null){
			s.push(node);
			node=node.getLeftChild();
		}
		while(s.peek().getRightChild()==null){
			System.out.println(s.pop().getData());
		}
	}
	
	private static int count(Node node){
		if(node==null){
			return 0;
		}
		else{
			return 1+count(node.getLeftChild())+count(node.getRightChild());
		}
	}
	
	private static int counthalfNode(Node node){
		int result=0;
		if(node==null){
			return 0;
		}
		else{
			if((node.getLeftChild()!=null && node.getRightChild()==null) || (node.getRightChild()!=null && node.getLeftChild()==null)){
				result++;
			}
			else{
				result=result+count(node.getLeftChild())+count(node.getRightChild());
			}
		}
		return result;
	}

}
