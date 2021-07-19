package binaryTree;

public class DeleteANodeInBinaryTree {
	
	public static void main(String[] args) {
		
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(8));
		rootNode.setRightChild(new Node(5));
		rootNode.getLeftChild().setLeftChild(new Node(90));
		rootNode.getLeftChild().setRightChild(new Node(56));
		rootNode.getRightChild().setLeftChild(new Node(23));
		rootNode.getRightChild().setRightChild(new Node(19));
		deleteANode(rootNode,56);
	}
	
	private static void deleteANode(Node node,int data){
		//Node deepestNode=deepestNode(node);
	}
	
	

}
