package longestPallindromicSubsequence;

public class LongestPallindromicSubsequence {
	
	public void longestPallindromicSubsequence(String inputString){
		char[] inputArray=inputString.toCharArray();
		int[][] countArray=new int[inputArray.length][inputArray.length];
		for(int i=0;i<countArray.length;i++){
			countArray[i][i]=1;
		}
		int noOfIterations=inputString.length()-2;
		int rowEndIndex=inputString.length()-2;
		int columnStartIndex=1;	
		while(noOfIterations>=0){
			int tempRowNumber=0;
			int tempColumnNumber=columnStartIndex;
			while(tempRowNumber<=rowEndIndex && tempColumnNumber<=inputString.length()-1){
				if(inputArray[tempRowNumber]==inputArray[tempColumnNumber]){
					countArray[tempRowNumber][tempColumnNumber]=countArray[tempRowNumber+1][tempColumnNumber-1]+2;
				}
				else{
					countArray[tempRowNumber][tempColumnNumber]=
							Math.max(countArray[tempRowNumber][tempColumnNumber-1], countArray[tempRowNumber+1][tempColumnNumber]);
				}
				tempRowNumber++;
				tempColumnNumber++;
			}
			rowEndIndex--;
			columnStartIndex++;
			noOfIterations--;
		}
		/*for(int i=0;i<countArray.length;i++){
			for(int j=0;j<countArray[i].length;j++){
				System.out.print(countArray[i][j]+" ");
			}
			System.out.println();
		}*/
		showPallindromicSubsequence(countArray,inputString);
	}
	
	private void showPallindromicSubsequence(int[][] countArray,String inputString){
		char[] subsequenceArray=new char[countArray[0][inputString.length()-1]];
		int rowIndex=0;
		int columnIndex=inputString.length()-1;
		int startIndex=0;
		int endIndex=subsequenceArray.length-1;
		while(countArray[rowIndex][columnIndex]!=0 && rowIndex>=0 && columnIndex>=0){
			if(inputString.charAt(rowIndex)==inputString.charAt(columnIndex)){
				subsequenceArray[startIndex]=inputString.charAt(rowIndex);
				subsequenceArray[endIndex]=inputString.charAt(columnIndex);
				startIndex++;
				endIndex--;
				rowIndex=rowIndex+1;
				columnIndex=columnIndex-1;
			}
			else{
				if(countArray[rowIndex][columnIndex-1]>=countArray[rowIndex+1][columnIndex]){
					columnIndex=columnIndex-1;
				}
				else{
					rowIndex=rowIndex+1;
				}
			}
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<subsequenceArray.length;i++){
			sb.append(subsequenceArray[i]);
		}
		System.out.println("Longest Pallindromic Subsequence : "+sb);
	}

}
