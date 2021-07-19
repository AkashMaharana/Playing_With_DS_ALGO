package com.akash.maharana.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderTraversal {
	
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
		verticalOrderTraversal(rootNode);
	}
	
	private static void verticalOrderTraversal(Node node){
		if(node==null){
			return;
		}
		Map<Integer,List<Integer>> m=new TreeMap<>();
		printVerticalOrder(node,m,0);
		Set<Map.Entry<Integer,List<Integer>>> entry=m.entrySet();
		for(Map.Entry<Integer, List<Integer>> entrySet : entry){
			System.out.print("{ "+entrySet.getKey() + " : ");
			for(Integer i : entrySet.getValue()){
				System.out.print(i+" , ");
			}
			System.out.println(" }");
			System.out.println();
		}
 	}
	
	private static void printVerticalOrder(Node node,Map<Integer,List<Integer>> m,int distance){
		if(node==null){
			return;
		}
		List<Integer> l=m.get(distance);
		if(l==null){
			l=new ArrayList<>();
			l.add(node.getData());
		}
		else{
			l.add(node.getData());
		}
		m.put(distance, l);
		printVerticalOrder(node.getLeftChild(),m,distance-1);
		printVerticalOrder(node.getRightChild(),m,distance+1);
	}

}
