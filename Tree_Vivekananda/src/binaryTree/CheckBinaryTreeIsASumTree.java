package binaryTree;

public class CheckBinaryTreeIsASumTree {
	
	public static void main(String[] args) {
		Node rootNode1=new Node(48);
		rootNode1.setLeftChild(new Node(33));
		rootNode1.setRightChild(new Node(15));
		rootNode1.getLeftChild().setLeftChild(new Node(16));
		rootNode1.getLeftChild().setRightChild(new Node(17));
		System.out.println(checkSumTree(rootNode1));
	}
	
	private static boolean checkSumTree(Node node){
		if(node==null){
			return true;
		}
		if(node.getLeftChild()==null && node.getRightChild()==null){
			return true;
		}
		int sum=0;
		int leftSum=addNodeValues(node.getLeftChild(),sum);
		int rightsum=addNodeValues(node.getRightChild(),sum);
		if(leftSum+rightsum==node.getData()){
			if(checkSumTree(node.getLeftChild()) && checkSumTree(node.getRightChild())){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	private static int addNodeValues(Node node,int sum){
		if(node.getLeftChild()!=null){
			addNodeValues(node.getLeftChild(),sum);
		}
		sum=sum+node.getData();
		if(node.getRightChild()!=null){
			addNodeValues(node.getRightChild(),sum);
		}
		return sum;
	}

}
