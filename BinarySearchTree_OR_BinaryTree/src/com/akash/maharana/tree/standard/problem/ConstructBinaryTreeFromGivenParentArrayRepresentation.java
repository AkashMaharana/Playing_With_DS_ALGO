package com.akash.maharana.tree.standard.problem;

public class ConstructBinaryTreeFromGivenParentArrayRepresentation {
	
	public static void main(String[] args) {
		int[] parent = {-1, 0, 0, 1, 1, 3, 5};
		constructBinaryTree(parent);
	}
	
	private static void constructBinaryTree(int[] parent){
		Node rootNode=null;
		for(int i=0;i<parent.length;i++){
			if(parent[i]==-1){
				rootNode=new Node(i);
				break;
			}
		}
		constructTree(rootNode,parent);
		inOrderTraversal(rootNode);
		
	}
	
	private static void inOrderTraversal(Node node){
		if(node.getLeftChild()!=null){
			inOrderTraversal(node.getLeftChild());
		}
		System.out.print(node.getData()+" ");
		if(node.getRightChild()!=null){
			inOrderTraversal(node.getRightChild());
		}
	}
	
	private static void constructTree(Node node,int[] parent){
		if(node==null){
			return;
		}
		for(int i=0;i<parent.length;i++){
			if(node.getData()==parent[i]){
				if(node.getLeftChild()==null){
					node.setLeftChild(new Node(i));
					continue;
				}
				if(node.getRightChild()==null){
					node.setRightChild(new Node(i));
					continue;
				}
			}
		}
		constructTree(node.getLeftChild(),parent);
		constructTree(node.getRightChild(),parent);
	}

}
