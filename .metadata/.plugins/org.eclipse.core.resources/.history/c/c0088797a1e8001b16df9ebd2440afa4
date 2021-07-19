package geeksForGeeks;

public class HeightOfTree {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(10));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(9));
		System.out.println(getHeight(rootNode));
	}
	
	private static int getHeight(Node node){
		if(node==null){
			return 0;
		}
		return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1;
	}

}
