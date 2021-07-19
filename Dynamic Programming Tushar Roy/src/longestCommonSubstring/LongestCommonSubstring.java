package longestCommonSubstring;

public class LongestCommonSubstring {
	
	public int longestCommonSubstring(String input1,String input2){
		int[][] commonMatrix=new int[input1.length()+1][input2.length()+1];	
		int maxLength=0;
		int rowIndex=0;
		int columnIndex=0;
		for(int i=1;i<=input1.length();i++){
			for(int j=1;j<=input2.length();j++){
				if(input1.charAt(i-1)==input2.charAt(j-1)){
					commonMatrix[i][j]=1+commonMatrix[i-1][j-1];
					if(commonMatrix[i][j]>maxLength){
						maxLength=commonMatrix[i][j];
						rowIndex=i;
						columnIndex=j;
					}
				}
				else{
					commonMatrix[i][j]=0;
				}
			}
		}
		printLongestCommonSubstring(commonMatrix,rowIndex,columnIndex,input1,input2);
		return maxLength;
	}
	
	private void printLongestCommonSubstring(int[][] commonMatrix,int rowIndex,int columnIndex,String input1,String input2){
		String commonSubstring="";
		int i=rowIndex;
		for(int j=columnIndex;j>0;j--){
			if(commonMatrix[i][j]!=0){
				commonSubstring=commonSubstring+input1.charAt(i-1);
				columnIndex=columnIndex-1;
				i=i-1;
			}
			else{
				break;
			}
		}
		System.out.println("Common Substring : "+new StringBuffer(commonSubstring).reverse());
	}
	
	public int printLongestCommonSubstringRecursive(int i,int j,int count,String input1,String input2){
		if(i==0 || j==0){
			return count;
		}
		if(input1.charAt(i-1)==input2.charAt(j-1)){
			count=printLongestCommonSubstringRecursive(i-1, j-1, count+1, input1, input2);
		}
		count=Math.max(count, Math.max(printLongestCommonSubstringRecursive(i-1, j, 0, input1, input2),
				printLongestCommonSubstringRecursive(i, j-1, 0, input1, input2)));
		return count;
	}

}
