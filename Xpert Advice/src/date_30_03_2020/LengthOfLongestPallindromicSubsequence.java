package date_30_03_2020;

public class LengthOfLongestPallindromicSubsequence {
	
	public static void main(String[] args) {
		String input="BBABCBCAB";
		System.out.println("Length of longest pallindromic subsequence DP : "+lengthOflongestPallindromicSubsequenceDP(input));
		System.out.println("Length of longest pallindromic subsequence Recusrion "+lengthOfLongestPallindromicSubsequenceRecursive(input, 0, input.length()-1));
	}
	
	private static int lengthOflongestPallindromicSubsequenceDP(String input) {
		int[][] tempMatrix=new int[input.length()][input.length()];
		for(int i=0;i<input.length();i++) {
			tempMatrix[i][i]=1;
		}
		int i=1;
		while(i<input.length()) {
			int j=0;
			int tempIndex=i;
			while(tempIndex<input.length()) {
				if(input.charAt(j)==input.charAt(tempIndex)) {
					tempMatrix[j][tempIndex]=2+tempMatrix[j+1][tempIndex-1];
				}
				else {
					tempMatrix[j][tempIndex]=Math.max(tempMatrix[j][tempIndex-1], tempMatrix[j+1][tempIndex]);
				}
				tempIndex++;
				j++;
			}
			i++;
		}
		return tempMatrix[0][input.length()-1];
	}
	
	private static int lengthOfLongestPallindromicSubsequenceRecursive(String input,int startIndex,int endIndex) {
		if(startIndex==endIndex) {
			return 1;
		}
		if(input.charAt(startIndex)==input.charAt(endIndex) && startIndex+1==endIndex) {
			return 2;
		}
		if(input.charAt(startIndex)==input.charAt(endIndex)) {
			return lengthOfLongestPallindromicSubsequenceRecursive(input, startIndex+1, endIndex-1)+2;
		}
		return Math.max(lengthOfLongestPallindromicSubsequenceRecursive(input, startIndex+1, endIndex),
				lengthOfLongestPallindromicSubsequenceRecursive(input, startIndex, endIndex-1));
		
	}

}
