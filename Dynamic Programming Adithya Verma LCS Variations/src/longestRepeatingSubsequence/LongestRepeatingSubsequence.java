package longestRepeatingSubsequence;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		String s1 = "AABEBCDD";
		System.out.println("Length of longest repeating subsequence : "
				+ lengthOfLongestRepeatingSubsequence(s1, new StringBuffer(s1).toString()));
	}

	private static int lengthOfLongestRepeatingSubsequence(String s1, String s2) {
		int[][] temp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
					temp[i][j] = 1 + temp[i - 1][j - 1];
				} else {
					temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
				}
			}
		}
		return temp[s1.length()][s2.length()];
	}

}
