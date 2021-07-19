package minimumNumberOfDeletionToMakeAStringPallindrome;

public class MinimumNumberOfDeletionToMakeAStringPallindrome {

	public static void main(String[] args) {
		String input = "agbcba";
		System.out.println("Minimum number of deletion to make a string pallindrome : "
				+ minimumNumberOfDeletion(input, new StringBuffer(input).reverse().toString()));
	}

	private static int minimumNumberOfDeletion(String s1, String s2) {
		int[][] temp=new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					temp[i][j]=temp[i-1][j-1]+1;
				}
				else {
					temp[i][j]=Math.max(temp[i-1][j], temp[i][j-1]);
				}
			}
		}
		return s1.length()-temp[s1.length()][s2.length()];
		// MinimumNumberOfDeletionToMakeAStringPallindrome = s1.length()-LongestCommonSubsequence(s1,s1.reverse())
		// LongestPallindromicSubsequence(s1)= LongestCommonSubsequence(s1,s2.reverse())
		// ShortestCommonSupersequence= (s1.length()+s2.length())-longestCommonSubsequence(s1,s2)
	}

}
