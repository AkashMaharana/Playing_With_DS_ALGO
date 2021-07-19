package geeksForGeeks;

public class DiameterOfTree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(10));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(9));
		System.out.println(diameterOfTree(rootNode));
	}
	
	private static int diameterOfTree(Node node){
		if(node==null){
			return 0;
		}
		int leftmax=getHeight(node.getLeftChild());
		int rightMax=getHeight(node.getRightChild());
		int leftSubMax=diameterOfTree(node.getLeftChild());
		int rightSubmax=diameterOfTree(node.getRightChild());
		return Math.max((leftmax+rightMax+1), Math.max(leftSubMax, rightSubmax));
	}
	
	private static int getHeight(Node node){
		if(node==null){
			return 0;
		}
		return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1;
	}

}
