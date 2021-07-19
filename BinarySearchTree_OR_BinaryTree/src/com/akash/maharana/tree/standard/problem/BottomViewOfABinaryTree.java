package com.akash.maharana.tree.standard.problem;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;

import java.util.ArrayList;
import java.util.Set;

public class BottomViewOfABinaryTree {
	
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
		rootNode.getLeftChild().getLeftChild().getLeftChild().getLeftChild().setRightChild(new Node(90));
		rootNode.getRightChild().getRightChild().setRightChild(new Node(11));
		rootNode.getRightChild().getRightChild().getRightChild().setLeftChild(new Node(12));
		rootNode.getRightChild().getRightChild().getRightChild().setRightChild(new Node(13));
		rootNode.getRightChild().getLeftChild().setLeftChild(new Node(14));
		rootNode.getRightChild().getLeftChild().setRightChild(new Node(15));
		rootNode.getRightChild().getLeftChild().getLeftChild().setLeftChild(new Node(16));
		rootNode.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node(17));
		bottomViewOfBinaryTree(rootNode);
	}
	
	private static void bottomViewOfBinaryTree(Node node){
		Map<Integer,List<Integer>> m=new TreeMap<>();
		veticalOrderTraversal(node,m,0);
		Set<Map.Entry<Integer,List<Integer>>> s=m.entrySet();
		for(Map.Entry<Integer, List<Integer>> mm : s){
			System.out.println(mm.getValue().get(mm.getValue().size()-1));
		}
	}
	
	private static void veticalOrderTraversal(Node node,Map<Integer,List<Integer>> m,int distance){
		if(node==null){
			return;
		}
		List<Integer> l=m.get(distance);
		if(l==null){
			l=new ArrayList<>();
			l.add(node.getData());
		}
		else{
			m.get(distance).add(node.getData());
		}
		m.put(distance, l);
		veticalOrderTraversal(node.getLeftChild(),m,distance-1);
		veticalOrderTraversal(node.getRightChild(),m,distance+1);
	}

}
