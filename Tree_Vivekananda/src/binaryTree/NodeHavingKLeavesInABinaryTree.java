package binaryTree;

public class NodeHavingKLeavesInABinaryTree {
	
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
		rootNode.getRightChild().getRightChild().setRightChild(new Node(11));
		rootNode.getRightChild().getRightChild().getRightChild().setLeftChild(new Node(12));
		rootNode.getRightChild().getRightChild().getRightChild().setRightChild(new Node(13));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(14));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node(16));
		rootNode.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(17));
		nodesHavingKLeaves(rootNode,2);
	}
	
	private static void nodesHavingKLeaves(Node node,int noOfLeaves){
		if(node==null){
			return;
		}
		printNodesWithKLeaves(node,noOfLeaves);
	}
	
	private static int printNodesWithKLeaves(Node node,int noOfLeaves){
		if(node==null){
			return 0;
		}
		if(node.getLeftChild()==null && node.getRightChild()==null){
			return 1;
		}
		int leftSum=printNodesWithKLeaves(node.getLeftChild(), noOfLeaves);
		int rightsum=printNodesWithKLeaves(node.getRightChild(), noOfLeaves);
		if(leftSum+rightsum==noOfLeaves){
			System.out.println(node.getData());
		}
		return leftSum+rightsum;
	}

}
