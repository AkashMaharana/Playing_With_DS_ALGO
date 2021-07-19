package longestCommonSubsequence;

public class LongestCommonSubsequenceRecursive {

	public static void main(String[] args) {
		String s1 = "akash";
		String s2 = "maharana";
		System.out.println("Length of Longest Common Subsequence : "
				+ lengthOfLongestCommonSubsequence(s1, s2, s1.length(), s2.length()));
	}

	private static int lengthOfLongestCommonSubsequence(String s1, String s2, int length1, int length2) {
		if (length1 == 0 || length2 == 0) {
			return 0;
		}
		if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1)) {
			return 1 + lengthOfLongestCommonSubsequence(s1, s2, length1 - 1, length2 - 1);
		}
		return Math.max(lengthOfLongestCommonSubsequence(s1, s2, length1 - 1, length2),
				lengthOfLongestCommonSubsequence(s1, s2, length1, length2 - 1));
	}

}
