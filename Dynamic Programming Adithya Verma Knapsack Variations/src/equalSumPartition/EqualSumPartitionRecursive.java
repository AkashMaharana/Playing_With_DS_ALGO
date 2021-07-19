package equalSumPartition;

public class EqualSumPartitionRecursive {
	
	public static void main(String[] args) {
		int[] input={1, 5, 11, 5};
		System.out.println("Equal sum partition exists : "+isEqualSumPartitionExistsRecursive(input));
	}
	
	private static boolean isEqualSumPartitionExistsRecursive(int[] input) {
		int sum=0;
		for(int i=0;i<input.length;i++) {
			sum=sum+input[i];
		}
		if(sum%2!=0) {
			return false;
		}
		else {
			return isSubsetSumExistsRecursvie(input,sum/2,input.length);
		}
	}
	
	private static boolean isSubsetSumExistsRecursvie(int[] input,int target,int length) {
		if(target==0) {
			return true;
		}
		if(length==0 && target!=0) {
			return false;
		}
		return isSubsetSumExistsRecursvie(input, target-input[length-1], length-1) || 
				isSubsetSumExistsRecursvie(input, target, length-1);
	}
	
}
