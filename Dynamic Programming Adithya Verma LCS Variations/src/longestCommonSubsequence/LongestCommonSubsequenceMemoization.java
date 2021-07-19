package longestCommonSubsequence;

public class LongestCommonSubsequenceMemoization {

	private static int[][] temp;

	public static void main(String[] args) {
		String s1 = "akash";
		String s2 = "maharana";
		temp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = -1;
			}
		}
		System.out.println("Length of Longest Common Subsequence is : "
				+ lengthOfLongestSubsequence(s1, s2, s1.length(), s2.length()));
	}

	private static int lengthOfLongestSubsequence(String s1, String s2, int length1, int length2) {
		if (length1 == 0 || length2 == 0) {
			return 0;
		}
		if(temp[length1][length2]!=-1) {
			return temp[length1][length2];
		}
		if (s1.charAt(length1-1) == s2.charAt(length2-1)) {
			return temp[length1][length2] = 1 + lengthOfLongestSubsequence(s1, s2, length1 - 1, length2 - 1);
		} else {
			return temp[length1][length2] = Math.max(lengthOfLongestSubsequence(s1, s2, length1 - 1, length2),
					lengthOfLongestSubsequence(s1, s2, length1, length2 - 1));
		}
	}

}
