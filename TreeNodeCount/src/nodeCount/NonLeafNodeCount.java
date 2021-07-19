package nodeCount;

public class NonLeafNodeCount {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(8));
		System.out.println(nonLeafNodeCount(rootNode));
	}
	
	private static int nonLeafNodeCount(Node node){
		if(node==null || (node.getLeftChild()==null && node.getRightChild()==null)){
			return 0;
		}
		else{
			return 1+nonLeafNodeCount(node.getLeftChild())+nonLeafNodeCount(node.getRightChild());
		}
	}
	
}
