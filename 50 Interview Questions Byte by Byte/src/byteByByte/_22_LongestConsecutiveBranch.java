package byteByByte;

public class _22_LongestConsecutiveBranch {
	
	public static void main(String[] args) {
		LongNodeHelper helper=new LongNodeHelper();
		LongNode root=new LongNode(0);
		root.left=new LongNode(1);
		root.left.left=new LongNode(1);
		root.left.right=new LongNode(2);
		root.right=new LongNode(2);
		root.right.left=new LongNode(1);
		root.right.right=new LongNode(3);
		System.out.println("Test Case 1 : "+helper.lengthOfBranch(root));
		
		LongNode root2=new LongNode(6);
		root2.right=new LongNode(9);
		root2.right.right=new LongNode(10);
		root2.right.right.right=new LongNode(11);
		root2.right.left=new LongNode(7);
		System.out.println("Test Case 2 : "+helper.lengthOfBranch(root2));
		
		LongNode root3=new LongNode(1);
		root3.left=new LongNode(2);
		root3.left.left=new LongNode(3);
		root3.right=new LongNode(4);
		root3.right.left=new LongNode(5);
		root3.right.right=new LongNode(6);
		root3.right.right.left=new LongNode(7);
		root3.right.right.left.left=new LongNode(8);
		System.out.println("Test Case 3 : "+helper.lengthOfBranch(root3));
	}

}
	
class LongNode {
	int data;
	LongNode left;
	LongNode right;

	public LongNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class LongNodeHelper{
	
	public void lengthOfChain(LongNode node,int currentLength,int expected,Result result) {
		if(node==null) {
			return;
		}
		if(node.data==expected) {
			currentLength++;
		}
		else {
			currentLength=1;
		}
		result.result=Math.max(currentLength, result.result);
		lengthOfChain(node.left,currentLength,node.data+1,result);
		lengthOfChain(node.right,currentLength,node.data+1,result);
	}
	
	public int lengthOfBranch(LongNode node) {
		if(node==null) {
			return 0;
		}
		Result result=new Result();
		lengthOfChain(node,0,node.data,result);
		return result.result;
	}
	
}

class Result{
	int result=0;
}
