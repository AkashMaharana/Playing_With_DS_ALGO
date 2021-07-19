package binaryTree;

public class DeepestNodeOfABinaryTree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(8));
		rootNode.setRightChild(new Node(5));
		rootNode.getLeftChild().setLeftChild(new Node(90));
		rootNode.getLeftChild().setRightChild(new Node(56));
		rootNode.getRightChild().setLeftChild(new Node(23));
		rootNode.getRightChild().setRightChild(new Node(19));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(89));
		deepestNodeOfABinaryTree(rootNode);
	}
	
	private static void deepestNodeOfABinaryTree(Node node){
		int height=getHeight(node);
		deepestNode(node,height);
	}
	
	private static void deepestNode(Node node,int level){
		if(node==null){
			return;
		}
		if(level==1){
			System.out.print(node.getData()+" ");
		}
		else if(level>1){
			deepestNode(node.getLeftChild(), level-1);
			deepestNode(node.getRightChild(), level-1);
		}
		
	}
	
	private static int getHeight(Node node){
		if(node==null){
			return 0;
		}
		return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1;
	}

}
