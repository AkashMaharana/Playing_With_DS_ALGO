package binaryTree;

public class IsFoldable {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getRightChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		System.out.println(isFoldable(rootNode));
	}
	
	private static boolean isFoldable(Node node){
		if(node==null){
			return false;
		}
		return foldable(node.getLeftChild(),node.getRightChild());
	}
	
	private static boolean foldable(Node node1,Node node2){
		if(node1==null && node2==null){
			return true;
		}
		if(node1==null || node2==null){
			return false;
		}
		return foldable(node1.getLeftChild(),node2.getRightChild()) && foldable(node1.getRightChild(), node2.getLeftChild());
	}

}
