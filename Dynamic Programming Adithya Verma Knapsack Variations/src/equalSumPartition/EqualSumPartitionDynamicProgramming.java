package equalSumPartition;

public class EqualSumPartitionDynamicProgramming {
	
	public static void main(String[] args) {
		int[] input={1, 5, 11, 5};
		System.out.println("Equal sum partition exists : "+isEqualSumPartitionExistsDP(input));
	}
	
	private static boolean isEqualSumPartitionExistsDP(int[] input) {
		int sum=0;
		for(int i=0;i<input.length;i++) {
			sum=sum+input[i];
		}
		if(sum%2!=0) {
			return false;
		}
		else {
			return isSubsetSumExistsDP(input,sum/2);
		}
	}
	
	private static boolean isSubsetSumExistsDP(int[] input,int target) {
		boolean[][] temp=new boolean[input.length+1][target+1];
		for(int i=0;i<temp.length;i++) {
			temp[i][0]=true;
		}
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(input[i-1]>j) {
					temp[i][j]=temp[i-1][j];
				}
				else {
					temp[i][j]=temp[i-1][j-input[i-1]];
				}
			}
		}
		return temp[input.length][target];
	}

}
