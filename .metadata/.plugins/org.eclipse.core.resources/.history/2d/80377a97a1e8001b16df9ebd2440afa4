package geeksForGeeks;

public class SpiralTraversalOfTree {
	
	//needs to be completed
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		spiralTraversal(rootNode);
	}
	
	private static void spiralTraversal(Node node){
		int height=getHeight(node);
		for(int i=1;i<=height;i++){
			levelOrderTraversal(node,i);
		}
	}
	
	private static int getHeight(Node node){
		if(node==null){
			return 0;
		}
		return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())+1);
	}
	
	private static void levelOrderTraversal(Node node,int level){
		if(node==null){
			return;
		}
		if(level==1){
			System.out.print(node.getData()+" ");
		}
		if(level%2==0){
			levelOrderTraversal(node.getLeftChild(), level-1);
			levelOrderTraversal(node.getRightChild(), level-1);
		}
		else{
			levelOrderTraversal(node.getRightChild(), level-1);
			levelOrderTraversal(node.getLeftChild(), level-1);
		}
	}
	

}
