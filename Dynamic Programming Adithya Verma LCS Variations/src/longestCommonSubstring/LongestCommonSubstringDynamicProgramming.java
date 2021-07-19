package longestCommonSubstring;

public class LongestCommonSubstringDynamicProgramming {
	
	public static void main(String[] args) {
		String s1="akash";
		String s2="ka";
		System.out.println("Length of longest common substring : "+longestCommonSubstring(s1,s2));
	}

	private static int longestCommonSubstring(String s1, String s2) {
		int[][] temp=new int[s1.length()+1][s2.length()+1];
		int maximum=0;
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					temp[i][j]=temp[i-1][j-1]+1;
					if(temp[i][j]>maximum) {
						maximum=temp[i][j];
					}
				}
				else {
					temp[i][j]=0;
				}
			}
		}
		return maximum;
	}

}
