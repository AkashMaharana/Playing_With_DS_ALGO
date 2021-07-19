package longestCommonSubsequence;

public class LongestCommonSubsequenceDynamicProgramming {

	public static void main(String[] args) {
		String s1 = "akash";
		String s2 = "maharanah";
		System.out.println("Length of longest common subsequence : " + lengthOfLongestCommonSubsequence(s1, s2));
	}

	private static int lengthOfLongestCommonSubsequence(String s1, String s2) {
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
		printCommonSubsequence(temp,s1,s2);
		return temp[s1.length()][s2.length()];
	}
	
	private static void printCommonSubsequence(int[][] temp, String s1, String s2) {
		int i=s1.length();
		int j=s2.length();
		StringBuffer sb=new StringBuffer();
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(temp[i-1][j]>temp[i][j-1]) {
					i--;
				}
				else {
					j--;
				}
			}
		}
		System.out.println("Longest common subsequence is : "+sb.reverse());
	}

}
