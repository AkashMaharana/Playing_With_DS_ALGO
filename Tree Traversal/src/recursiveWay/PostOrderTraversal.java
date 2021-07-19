package recursiveWay;

public class PostOrderTraversal {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		postOrderTraversalRecursiveWay(rootNode);
	}
	
	private static void postOrderTraversalRecursiveWay(Node node){
		if(node.getLeftChild()!=null){
			postOrderTraversalRecursiveWay(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			postOrderTraversalRecursiveWay(node.getRightChild());
		}
		System.out.print(node.getData()+" ");
	}

}
