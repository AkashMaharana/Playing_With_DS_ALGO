package recursiveWay;

public class LevelOrderTraversal {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		levelOrderTraversalIterativeWay(rootNode);
	}
	
	private static void levelOrderTraversalIterativeWay(Node node){
		int height=getHeight(node);
		for(int i=1;i<=height;i++){
			printGivenLevel(node,i);
		}
	}
	
	private static void printGivenLevel(Node node,int level){
		if(node==null){
			return;
		}
		if(level==1){
			System.out.print(node.getData()+" ");
		}
		else if(level>1){
			printGivenLevel(node.getLeftChild(), level-1);
			printGivenLevel(node.getRightChild(), level-1);
		}
	}
	
	private static int getHeight(Node node){
		if(node == null){
			return 0;
		}
		else{
			int leftHeight=getHeight(node.getLeftChild());
			int rightHeight=getHeight(node.getRightChild());
			return Math.max(leftHeight, rightHeight)+1;
		}
	}

}
