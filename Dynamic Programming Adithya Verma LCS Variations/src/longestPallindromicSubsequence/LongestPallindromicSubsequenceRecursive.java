package longestPallindromicSubsequence;

public class LongestPallindromicSubsequenceRecursive {

	public static void main(String[] args) {
		String input = "BBABCBCAB";
		System.out.println("Length of longest pallindromic subsequence : "
				+ lengthOfLongestPallindromicSubsequence(input, 0,input.length()-1));
	}

	private static int lengthOfLongestPallindromicSubsequence(String input, int start,int end) {
		if(start==end) {
			return 1;
		}
		if(input.charAt(start)==input.charAt(end)) {
			return 2+lengthOfLongestPallindromicSubsequence(input, start+1, end-1);
		}
		return Math.max(lengthOfLongestPallindromicSubsequence(input, start+1, end), 
				lengthOfLongestPallindromicSubsequence(input, start, end-1));
	}

}
