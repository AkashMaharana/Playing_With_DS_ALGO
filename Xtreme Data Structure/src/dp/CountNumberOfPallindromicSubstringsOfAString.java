package dp;

public class CountNumberOfPallindromicSubstringsOfAString {
	
	public static void main(String[] args) {
		String input="abbaeae";
		System.out.println("Number of pallindromic substring : "+countNumberOfPallindromicSubstring(input));
	}
	
	private static int countNumberOfPallindromicSubstring(String input) {
		boolean[][] temp=new boolean[input.length()][input.length()];
		for(int i=0;i<temp.length;i++) {
			temp[i][i]=true;
		}
		int count=0;
		int rowCount=temp.length-1;
	    int columnCount=1;
	    while(rowCount>=0){
	        int rowIndex=0;
	        int columnIndex=columnCount;
	        while(columnIndex<temp.length){
	            if((columnIndex-rowIndex)>1 && input.charAt(rowIndex)==input.charAt(columnIndex) && temp[rowIndex+1][columnIndex-1]){
	                temp[rowIndex][columnIndex]=true;
	                count=count+1;
	            }
	            else if((columnIndex-rowIndex)==1 && input.charAt(rowIndex)==input.charAt(columnIndex)){
	                temp[rowIndex][columnIndex]=true;
	                count=count+1;
	            }
	            rowIndex++;
	            columnIndex++;
	        }
	        rowCount--;
	        columnCount++;
	    }
	    return count;
	}

}
