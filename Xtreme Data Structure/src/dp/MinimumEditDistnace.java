package dp;

public class MinimumEditDistnace {
	
	public static void main(String[] args) {
		String s1="abcdef";
		String s2="agced";
		System.out.println("Minimum edit distance : "+editDistance(s1,s2));
	}
	
	private static int editDistance(String s1,String s2) {
		int[][] temp=new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<temp[0].length;i++) {
			temp[0][i]=i;
		}
		for(int i=1;i<temp.length;i++) {
			temp[i][0]=i;
		}
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					temp[i][j]=temp[i-1][j-1];
				}
				else {
					temp[i][j]=Math.min(Math.min(temp[i-1][j], temp[i][j-1]), temp[i-1][j-1])+1;
				}
			}
		}
		return temp[s1.length()][s2.length()];
	}

}
