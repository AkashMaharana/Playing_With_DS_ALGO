package binaryTree;

public class DiameterOfABinaryTree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(50);
		rootNode.setLeftChild(new Node(16));
		rootNode.setRightChild(new Node(90));
		rootNode.getLeftChild().setLeftChild(new Node(14));
		rootNode.getLeftChild().setRightChild(new Node(40));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode.getLeftChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getLeftChild().getRightChild().setLeftChild(new Node(35));
		rootNode.getLeftChild().getRightChild().setRightChild(new Node(45));
		rootNode.getLeftChild().getRightChild().getLeftChild().setLeftChild(new Node(32));
		rootNode.getLeftChild().getRightChild().getLeftChild().setRightChild(new Node(36));
		rootNode.getLeftChild().getRightChild().getLeftChild().getRightChild().setRightChild(new Node(37));
		rootNode.getRightChild().setRightChild(new Node(100));
		rootNode.getRightChild().setLeftChild(new Node(78));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(75));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(82));
		rootNode.getRightChild().getLeftChild().getRightChild().setLeftChild(new Node(81));
		rootNode.getRightChild().getLeftChild().getRightChild().getLeftChild().setLeftChild(new Node(79));
		rootNode.getRightChild().getLeftChild().getRightChild().setRightChild(new Node(85));
		rootNode.getRightChild().getLeftChild().getRightChild().getRightChild().setRightChild(new Node(87));
		rootNode.getRightChild().getLeftChild().getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(80));
		rootNode.getRightChild().getLeftChild().getRightChild().getRightChild().getRightChild().setRightChild(new Node(89));
		System.out.println(diameterOfABinaryTree(rootNode));
	}
	
	private static int diameterOfABinaryTree(Node node){
		if(node==null){
			return 0;
		}
		int leftMax=getHeight(node.getLeftChild());
		int rightMax=getHeight(node.getRightChild());
		int leftSubMax=diameterOfABinaryTree(node.getLeftChild());
		int rightSubMax=diameterOfABinaryTree(node.getRightChild());
		int finalDiameter=Math.max((leftMax+rightMax+1), Math.max(leftSubMax, rightSubMax));
		return finalDiameter;
	}
	
	private static int getHeight(Node node){
		if(node==null){
			return 0;
		}
		return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1;
	}

}
