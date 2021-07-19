package dp;

public class LengthOfLongestCommonSubstring {
	
	public static void main(String[] args) {
		String s1="GeeksforGeeks";
		String s2="GeeksQuiz";
		System.out.println("Length of longest common substring is : "+longestCommonSubstring(s1,s2));
	}
	
	private static int longestCommonSubstring(String s1,String s2) {
		int[][] temp=new int[s1.length()+1][s2.length()+1];
		int maxLength=0;
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					temp[i][j]=temp[i-1][j-1]+1;
					if(maxLength<temp[i][j]) {
						maxLength=temp[i][j];
					}
				}
			}
		}
		return maxLength;
	}

}
