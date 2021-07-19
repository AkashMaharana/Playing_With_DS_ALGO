package shortestCommonSupersequence;

//(s1.length()+s2.length())-longestCommonSubsequence(s1,s2)
public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		String s1="AGGTAB";
		String s2="GXTXAYB";
		System.out.println("Length of shortest common supersequence : "+lengthOfShortestCommonSupersequence(s1,s2));
	}

	private static int lengthOfShortestCommonSupersequence(String s1, String s2) {
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
		printShortestCommonSupersequence(temp,s1,s2);
		return (s1.length()+s2.length())-temp[s1.length()][s2.length()];
	}
	
	private static void printShortestCommonSupersequence(int[][] temp,String s1,String s2) {
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
					sb.append(s1.charAt(i-1));
					i--;
				}
				else {
					sb.append(s2.charAt(j-1));
					j--;
				}
			}
		}
		while(i>0) {
			sb.append(s1.charAt(i-1));
			i--;
		}
		while(j>0) {
			sb.append(s2.charAt(j-1));
			j--;
		}
		System.out.println("Shortest common supersequence is : "+sb.reverse().toString());
	}
}
