package recursiveWay;

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
		if(node.getLeftChild()!=null){
			inOrderTraversalIterativeWay(node.getLeftChild());
		}
		System.out.print(node.getData()+" ");
		if(node.getRightChild()!=null){
			inOrderTraversalIterativeWay(node.getRightChild());
		}
	}

}
