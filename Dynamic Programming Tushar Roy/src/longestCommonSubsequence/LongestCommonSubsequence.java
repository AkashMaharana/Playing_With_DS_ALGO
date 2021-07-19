package longestCommonSubsequence;

public class LongestCommonSubsequence {
	
	public void longestCommonSubsequence(String input1,String input2){
		int[][] subsequenceMatrix=new int[input1.length()+1][input2.length()+1];
		for(int i=1;i<=input1.length();i++){
			for(int j=1;j<=input2.length();j++){
				if(input1.charAt(i-1)==input2.charAt(j-1)){
					subsequenceMatrix[i][j]=1+subsequenceMatrix[i-1][j-1];
				}
				else{
					subsequenceMatrix[i][j]=Math.max(subsequenceMatrix[i-1][j], subsequenceMatrix[i][j-1]);
				}
			}
		}
		System.out.println("Length of common sub sequence : "+subsequenceMatrix[input1.length()][input2.length()]);
		printCommonSubsequence(subsequenceMatrix,input1,input2);
	}
	
	private void printCommonSubsequence(int[][] subsequenceMatrix,String input1,String input2){
		String commonSubsequence="";
		int i=input1.length();
		int j=input2.length();
		while(i>0 && j>0){
			if(subsequenceMatrix[i][j]==subsequenceMatrix[i-1][j]){
				i=i-1;
			}
			else if(subsequenceMatrix[i][j]==subsequenceMatrix[i][j-1]){
				j=j-1;
			}
			else{
				commonSubsequence=commonSubsequence+input1.charAt(i-1);
				i=i-1;
				j=j-1;
			}
		}
		System.out.println("Longest Common Subsequence : "+new StringBuffer(commonSubsequence).reverse());
	}

}
