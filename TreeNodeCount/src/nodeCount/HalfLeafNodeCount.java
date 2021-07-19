package nodeCount;

public class HalfLeafNodeCount {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(8));
		System.out.println(halfLeafNodeCount(rootNode));
	}
	
	private static int halfLeafNodeCount(Node node){
		if(node==null){
			return 0;
		}
		if((node.getLeftChild()==null && node.getRightChild()!=null) || (node.getLeftChild()!=null && node.getRightChild()==null)){
			return 1;
		}
		return halfLeafNodeCount(node.getLeftChild())+halfLeafNodeCount(node.getRightChild());
	}

}
