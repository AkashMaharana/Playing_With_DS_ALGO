package date_27_03_2020;

public class RandomBinaryTree {
	
	public static void main(String[] args) {
		RandomBinaryTreeNode root=new RandomBinaryTreeNode(10);
		root.leftNode=new RandomBinaryTreeNode(20);
		root.rightNode=new RandomBinaryTreeNode(30);
		root.leftNode.leftNode=new RandomBinaryTreeNode(40);
		root.leftNode.rightNode=new RandomBinaryTreeNode(50);
		root.rightNode.leftNode=new RandomBinaryTreeNode(60);
		root.rightNode.rightNode=new RandomBinaryTreeNode(70);
		
		insertChildrenCount(root);
		
		int data=getRandomNodeData(root);
		
		System.out.println(data);
		
	}
	
	private static int getRandomNodeData(RandomBinaryTreeNode node) {
		int randomNumber=(int) (Math.random()*(node.childrenCount+1));
		return randomData(node,randomNumber);
	}
	
	private static int randomData(RandomBinaryTreeNode node,int randomNumber) {
		if(node==null) {
			return 0;
		}
		if(randomNumber==getChildrenCount(node.leftNode)) {
			return node.data;
		}
		if(randomNumber<getChildrenCount(node.leftNode)) {
			return randomData(node.leftNode, randomNumber);
		}
		return randomData(node.rightNode,randomNumber-getChildrenCount(node.leftNode)-1);
	}
	
	private static int getChildrenCount(RandomBinaryTreeNode node) {
		if(node==null) {
			return 0;
		}
		return node.childrenCount+1;
	}
	
	private static RandomBinaryTreeNode insertChildrenCount(RandomBinaryTreeNode node) {
		if(node==null) {
			return node;
		}
		node.childrenCount=getElements(node)-1;
		node.leftNode=insertChildrenCount(node.leftNode);
		node.rightNode=insertChildrenCount(node.rightNode);
		return node;
	}
	
	private static int getElements(RandomBinaryTreeNode node) {
		if(node==null) {
			return 0;
		}
		return getElements(node.leftNode)+getElements(node.rightNode)+1;
	}

}

class RandomBinaryTreeNode{
	
	int data;
	RandomBinaryTreeNode leftNode;
	RandomBinaryTreeNode rightNode;
	int childrenCount;
	
	public RandomBinaryTreeNode(int data) {
		this.data=data;
		this.leftNode=null;
		this.rightNode=null;
		this.childrenCount=0;
	}
}
