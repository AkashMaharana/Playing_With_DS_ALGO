package practice;

import java.util.EnumSet;

public class Test {
	
	public static void main(String[] args) {
		int noOfRows=4;
		int noOfColumns=3;
		constructAMatrixInSpiralForm(noOfRows,noOfColumns);
	}

	private static void constructAMatrixInSpiralForm(int noOfRows, int noOfColumns) {
		int[][] resultantMatrix=new int[noOfRows][noOfColumns];
		int rowStartingIndex=0;
		int rowEndingIndex=noOfRows-1;
		int columnStartingIndex=0;
		int columnEndingIndex=noOfColumns-1;
		int numberToBePlaced=1;
		while(rowStartingIndex<=rowEndingIndex && columnStartingIndex<=columnEndingIndex){
			for(int i=columnStartingIndex;i<=columnEndingIndex;i++){
				resultantMatrix[rowStartingIndex][i]=numberToBePlaced;
				numberToBePlaced=numberToBePlaced+1;
			}
			rowStartingIndex++;
			for(int i=rowStartingIndex;i<=rowEndingIndex;i++){
				resultantMatrix[i][columnEndingIndex]=numberToBePlaced;
				numberToBePlaced=numberToBePlaced+1;
			}
			columnEndingIndex--;
			if(rowStartingIndex<=rowEndingIndex){
				for(int i=columnEndingIndex;i>=0;i--){
					resultantMatrix[rowEndingIndex][i]=numberToBePlaced;
					numberToBePlaced=numberToBePlaced+1;
				}
			}
			rowEndingIndex--;
			if(columnStartingIndex<=columnEndingIndex){
				for(int i=rowEndingIndex;i>=rowStartingIndex;i--){
					resultantMatrix[i][columnStartingIndex]=numberToBePlaced;
					numberToBePlaced++;
				}
			}
			columnStartingIndex++;
		}
		printSprialMatrix(resultantMatrix);
	}

	private static void printSprialMatrix(int[][] resultantMatrix) {
		for(int i=0;i<resultantMatrix.length;i++){
			for(int j=0;j<resultantMatrix[0].length;j++){
				System.out.print(resultantMatrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
}