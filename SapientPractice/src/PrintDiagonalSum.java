import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintDiagonalSum {
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(8);
		root.left=new TreeNode(3);
		root.left.left=new TreeNode(1);
		root.right=new TreeNode(10);
		root.right.left=new TreeNode(6);
		root.right.left.right=new TreeNode(7);
		root.right.left.left=new TreeNode(4);
		root.right.right=new TreeNode(14);
		root.right.right.left=new TreeNode(13);
		Map<Integer,List<Integer>> map=new TreeMap<>();
		printDiagonalSum(root,map,0);
		map.forEach((key,value)->{
			System.out.print(key+" : ");
			int sum=0;
			for(Integer integer : value) {
				sum=sum+integer;
			}
			System.out.print(sum);
			System.out.println();
		});
	}
	
	private static void printDiagonalSum(TreeNode node,Map<Integer,List<Integer>> map,int level) {
		if(node==null) {
			return;
		}
		if(map.get(level)==null) {
			List<Integer> list=new ArrayList<>();
			list.add(node.data);
			map.put(level, list);
		}
		else {
			map.get(level).add(node.data);
		}
		printDiagonalSum(node.left, map, level-1);
		printDiagonalSum(node.right, map, level);
	}

}
