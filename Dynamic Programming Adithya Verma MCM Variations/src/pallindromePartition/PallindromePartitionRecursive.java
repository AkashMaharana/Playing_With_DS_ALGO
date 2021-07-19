package pallindromePartition;

public class PallindromePartitionRecursive {

	public static void main(String[] args) {
		String input = "geek";
		System.out.println(
				"Minimum number of partitions required : " + minimumNumberOfPartitions(input, 0, input.length() - 1));
	}

	private static int minimumNumberOfPartitions(String input, int i, int j) {
		if(i>=j) {
			return 0;
		}
		if(isPallindrome(input,i,j)) {
			return 0;
		}
		int minimum=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int count=1+minimumNumberOfPartitions(input, i, k)+minimumNumberOfPartitions(input, k+1, j);
			if(count<minimum) {
				minimum=count;
			}
		}
		return minimum;
	}
	
	private static boolean isPallindrome(String input,int start,int end) {
		for(int i=start,j=end;i<j;i++,j--) {
			if(input.charAt(i)!=input.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
