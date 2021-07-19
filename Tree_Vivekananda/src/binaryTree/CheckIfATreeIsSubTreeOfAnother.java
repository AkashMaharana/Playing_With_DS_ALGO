package binaryTree;

public class CheckIfATreeIsSubTreeOfAnother {
	
	public static void main(String[] args) {
		Node rootNode=new Node(1);
		rootNode.setLeftChild(new Node(2));
		rootNode.setRightChild(new Node(3));
		rootNode.getLeftChild().setLeftChild(new Node(4));
		rootNode.getLeftChild().setRightChild(new Node(5));
		rootNode.getRightChild().setLeftChild(new Node(6));
		rootNode.getRightChild().setRightChild(new Node(7));
		rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(8));
		rootNode.getLeftChild().getLeftChild().setRightChild(new Node(9));
		rootNode.getLeftChild().getLeftChild().getLeftChild().setLeftChild(new Node(10));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(11));
		rootNode.getRightChild().getRightChild().getRightChild().setLeftChild(new Node(12));
		rootNode.getRightChild().getRightChild().getRightChild().setRightChild(new Node(13));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(14));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node(16));
		rootNode.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(17));
		
		Node rootNode1=new Node(6);
		rootNode1.setLeftChild(new Node(14));
		rootNode1.setRightChild(new Node(15));
		rootNode1.getLeftChild().setLeftChild(new Node(16));
		rootNode1.getLeftChild().setRightChild(new Node(17));
		
		System.out.println(checkSubTreeOrNot(rootNode,rootNode1));
	}
	
	private static boolean checkSubTreeOrNot(Node firstNode,Node secondNode){
		if(secondNode==null){
			return true;
		}
		if(firstNode==null){
			return false;
		}
		if(identical(firstNode,secondNode)){
			return true;
		}
		return checkSubTreeOrNot(firstNode.getLeftChild(), secondNode) || 
				checkSubTreeOrNot(firstNode.getRightChild(), secondNode);
	}
	
	private static boolean identical(Node firstNode,Node secondNode){
		if(firstNode==null && secondNode==null){
			return true;
		}
		if(firstNode!=null && secondNode!=null){
			return (firstNode.getData()==secondNode.getData()) && identical(firstNode.getLeftChild(), secondNode.getLeftChild()) &&
					identical(firstNode.getRightChild(), secondNode.getRightChild());
		}
		else{
			return false;
		}
	}

}
