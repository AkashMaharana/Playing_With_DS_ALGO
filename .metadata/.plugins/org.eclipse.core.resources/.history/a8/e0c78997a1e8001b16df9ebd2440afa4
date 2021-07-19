package geeksForGeeks;

public class FindANode {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		System.out.println(findANode(rootNode,6));
	}
	
	private static boolean findANode(Node node,int data){
		if(node==null){
			return false;
		}
		if(node.getData()==data){
			return true;
		}
		return findANode(node.getRightChild(), data) || findANode(node.getLeftChild(), data);
	}

}
