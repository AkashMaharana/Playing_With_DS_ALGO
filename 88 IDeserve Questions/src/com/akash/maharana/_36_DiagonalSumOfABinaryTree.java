package com.akash.maharana;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _36_DiagonalSumOfABinaryTree {
	
	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode(8);
		root.setLeft(new BinaryTreeNode(3));
		root.setRight(new BinaryTreeNode(10));
		root.getLeft().setLeft(new BinaryTreeNode(1));
		root.getRight().setLeft(new BinaryTreeNode(6));
		root.getRight().getLeft().setLeft(new BinaryTreeNode(4));
		root.getRight().getLeft().setRight(new BinaryTreeNode(7));
		root.getRight().setRight(new BinaryTreeNode(14));
		root.getRight().getRight().setLeft(new BinaryTreeNode(13));
		Map<Integer,List<Integer>> dataMap=new TreeMap<>();
		diagonalOrderTraversal(root,dataMap,0);
		Set<Map.Entry<Integer,List<Integer>>> entry=dataMap.entrySet();
		int sum=0;
		for(Map.Entry<Integer, List<Integer>> entrySet : entry){
			System.out.print("Diagonal "+entrySet.getKey() + " : ");
			for(Integer i : entrySet.getValue()){
				sum=sum+i;
			}
			System.out.println(sum);
			sum=0;
			System.out.println();
		}
	}
	
	private static void diagonalOrderTraversal(BinaryTreeNode node,Map<Integer,List<Integer>> dataMap,int distance) {
		if(node==null) {
			return;
		}
		List<Integer> tempList=dataMap.get(distance);
		if(tempList==null) {
			tempList=new ArrayList<>();
			tempList.add(node.getData());
		}
		else {
			tempList.add(node.getData());
		}
		dataMap.put(distance, tempList);
		diagonalOrderTraversal(node.getLeft(), dataMap, distance+1);
		diagonalOrderTraversal(node.getRight(), dataMap, distance);
	}

}
