package binaryTree;

public class LeftViewOfBinaryTree {
	
	static int maxLevel=0;
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(8));
		rootNode.getLeftChild().getLeftChild().setRightChild(new Node(9));
		rootNode.getLeftChild().getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode.getLeftChild().getLeftChild().getLeftChild().getLeftChild().setRightChild(new Node(90));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(11));
		rootNode.getRightChild().getRightChild().getRightChild().setLeftChild(new Node(12));
		rootNode.getRightChild().getRightChild().getRightChild().setRightChild(new Node(13));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(14));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node(16));
		rootNode.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(17));
		leftViewOfBinaryTree(rootNode);
	}
	
	private static void leftViewOfBinaryTree(Node node){
		if(node==null){
			return;
		}
		leftView(node,1);
	}
	
	private static void leftView(Node node,int level){
		if(node==null){
			return;
		}
		if(maxLevel<level){
			System.out.println(node.getData());
			maxLevel=level;
		}
		leftView(node.getLeftChild(), level+1);
		leftView(node.getRightChild(), level+1);
	}

}
