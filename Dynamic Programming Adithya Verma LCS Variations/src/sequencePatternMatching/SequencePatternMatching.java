package sequencePatternMatching;

public class SequencePatternMatching {
	
	public static void main(String[] args) {
		String s1="AXY";
		String s2="ADXCPY";
		System.out.println("Pattern of subsequence matched : "+isPatternMatched(s1,s2));
	}
	
	private static boolean isPatternMatched(String s1,String s2) {
		int lps=getLPS(s1,s2);
		return lps==s1.length();
	}
	
	private static int getLPS(String s1,String s2) {
		int[][] temp=new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<temp.length;i++) {
			for(int j=1;j<temp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					temp[i][j]=1+temp[i-1][j-1];
				}
				else {
					temp[i][j]=Math.max(temp[i-1][j], temp[i][j-1]);
				}
			}
		}
		return temp[s1.length()][s2.length()];
	}

}
