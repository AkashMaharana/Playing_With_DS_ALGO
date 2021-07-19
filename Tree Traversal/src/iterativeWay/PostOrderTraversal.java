package iterativeWay;

import java.util.Stack;

public class PostOrderTraversal {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		postOrderTraversalIterativeWay(rootNode);
	}
	
	private static void postOrderTraversalIterativeWay(Node node){
		Stack<Node> s=new Stack<>();
		while(true){
			if(node!=null){
				s.push(node);
				node=node.getLeftChild();
			}
			else{
				if(s.isEmpty()){
					break;
				}
				else{
					if(s.peek().getRightChild()==null){
						node=s.pop();
						System.out.print(node.getData()+" ");
						while(!s.isEmpty() && node==s.peek().getRightChild()){
							System.out.print(s.peek().getData()+" ");
							node=s.pop();
						}
					}
					if(!s.isEmpty()){
						node=s.peek().getRightChild();
					}
					else{
						node=null;
					}
				}
			}
		}
	}

}
