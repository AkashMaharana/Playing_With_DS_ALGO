package binaryTree;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;

public class TopViewOfABinaryTree {
	
	public static void main(String[] args) {
		Node rootNode1=new Node(48);
		rootNode1.setLeftChild(new Node(33));
		rootNode1.setRightChild(new Node(15));
		rootNode1.getLeftChild().setLeftChild(new Node(16));
		rootNode1.getLeftChild().setRightChild(new Node(17));
		topViewOfBinaryTree(rootNode1);
	}
	
	private static void topViewOfBinaryTree(Node node){
		Map<Integer,List<Integer>> m=new TreeMap<>();
		verticalOrderTraversal(node,m,0);
		Set<Map.Entry<Integer,List<Integer>>> s=m.entrySet();
		for(Map.Entry<Integer, List<Integer>> mm : s){
			System.out.print(mm.getValue().get(0)+" ");
		}
	}
	
	private static void verticalOrderTraversal(Node node,Map<Integer,List<Integer>> m,int distance){
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
		verticalOrderTraversal(node.getLeftChild(), m, distance-1);
		verticalOrderTraversal(node.getRightChild(), m, distance+1);
	}

}
