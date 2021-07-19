package wordBreakProblem;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class WordBreakingProblem {
	
	public void wordBreakProblem(Set<String> dictonary, String inputString){
		boolean[][] matchMatrix=new boolean[inputString.length()][inputString.length()];
		List<Integer> finalIndexList=new ArrayList<>();
		for(int i=0;i<inputString.length();i++){
			if(dictonary.contains(String.valueOf(inputString.charAt(i)))){
				matchMatrix[i][i]=true;
			}
			else{
				matchMatrix[i][i]=false;
			}
		}
		int rowIndex=inputString.length()-2;
		int columnIndex=1;
		while(rowIndex>=0){
			int tempRowIndex=0;
			int tempColumnIndex=columnIndex;
			while(tempRowIndex<=rowIndex && tempColumnIndex<=inputString.length()-1){
				//System.out.println("tempRowIndex : "+tempRowIndex+" tempColumnIndex : "+tempColumnIndex);
				if(validateSubstring(dictonary,inputString,tempRowIndex,tempColumnIndex,matchMatrix,finalIndexList)){
					matchMatrix[tempRowIndex][tempColumnIndex]=true;
				}
				else{
					matchMatrix[tempRowIndex][tempColumnIndex]=false;
				}
				tempColumnIndex++;
				tempRowIndex++;
			}
			rowIndex--;
			columnIndex++;
		}
		//for print match matrix
		/*System.out.println();
		for(int i=0;i<matchMatrix.length;i++){
			for(int j=0;j<matchMatrix[i].length;j++){
				System.out.print(matchMatrix[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println("Words can be broken : "+matchMatrix[0][inputString.length()-1]);
		printMatchedWords(inputString,finalIndexList);
	}
	
	private static void printMatchedWords(String inputString, List<Integer> indexList){
		
	}
	
	private static boolean validateSubstring(Set<String> dictonary,String inputString,int tempRowIndex,int tempColumnIndex,boolean[][] matchMatrix,List<Integer> finalList){
		boolean isValid=false;
		int columnDifference=(tempColumnIndex-tempRowIndex);
		if(dictonary.contains(inputString.substring(tempRowIndex, tempColumnIndex+1))){
			isValid=true;
			return isValid;
		}
		else{
			int columnIndex=tempRowIndex;
			while(columnIndex<tempColumnIndex && columnDifference>0){
				if(matchMatrix[tempRowIndex][columnIndex] && matchMatrix[columnIndex+1][tempColumnIndex]){
					isValid=true;
					if(tempColumnIndex-tempRowIndex>=2){
						finalList.add(columnIndex);
					}
					return isValid;
				}
				else{
					isValid=false;
				}
				columnDifference--;
				columnIndex++;
			}
		}
		return isValid;
	}

}
