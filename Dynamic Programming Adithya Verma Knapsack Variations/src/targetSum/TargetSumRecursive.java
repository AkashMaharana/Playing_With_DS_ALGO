package targetSum;

//https://leetcode.com/problems/target-sum/
public class TargetSumRecursive {
	
	public static void main(String[] args) {
		int[] input= {1,1,1,1,1};
		//int targetSum=3;
		int difference=4;
		System.out.println("Number of combination with the given difference is : "+countNumberOfSubset(input,difference,input.length));
	}
	
	private static int countNumberOfSubset(int[] input,int target,int length) {
		if(target==0 && length==0) {
			return 1;
		}
		if(target!=0 && length==0) {
			return 0;
		}
		return countNumberOfSubset(input, target-input[length-1], length-1)+
				countNumberOfSubset(input, target, length-1);
	}

}
