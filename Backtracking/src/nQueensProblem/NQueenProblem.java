package nQueensProblem;

public class NQueenProblem {
	
	public void nQueenProblem(int noOfQueens){
		int[][] chessBoard=new int[noOfQueens][noOfQueens];
		int[] outputArray=new int[noOfQueens];
		for(int i=0;i<noOfQueens;i++){
			printQueens(chessBoard,i,0,outputArray);
		}
	}
	
	private void printQueens(int[][] chessBoard,int columnIndex,int rowIndex,int[] outputArray){
		if(rowIndex==chessBoard.length){
			int[][] validCombination=new int[chessBoard.length][chessBoard.length];
			for(int i=0;i<outputArray.length;i++){
				validCombination[i][outputArray[i]]=2;
			}
			if(isValidCombination(outputArray,validCombination)){
				System.out.println("print combination");
				for(int i=0;i<outputArray.length;i++){
					System.out.print(outputArray[i]+" ");
				}
				System.out.println();
				System.out.println();
			}
			return;
		}
		outputArray[rowIndex]=columnIndex;
		for(int i=0;i<chessBoard.length;i++){
			printQueens(chessBoard, i, rowIndex+1, outputArray);
		}
		
	}
	
	private boolean isValidCombination(int[] outputArray,int[][] validCombination){
		for(int i=0;i<outputArray.length;i++){
			int rowIndex=i;
			int columnIndex=outputArray[i];
			int count=0;  
			for(int j=0;j<validCombination.length;j++){
				if(validCombination[rowIndex][j]==2){
					count=count+1;
				}
			}
			if(count>1){
				return false;
			}
			count=0;
			for(int j=0;j<validCombination.length;j++){
				if(validCombination[j][columnIndex]==2){
					count=count+1;
				}
			}
			if(count>1){
				return false;
			}
			count=0;
			while(rowIndex>=0 && columnIndex>=0 && 
					rowIndex<validCombination.length && columnIndex<validCombination.length){
				if(validCombination[rowIndex][columnIndex]==2){
					count=count+1;
				}
				rowIndex++;
				columnIndex++;
			}
			if(count>1){
				return false;
			}
			count=0;
			rowIndex=i;
			columnIndex=outputArray[i];
			while(rowIndex>=0 && columnIndex>=0 && 
					rowIndex<validCombination.length && columnIndex<validCombination.length){
				if(validCombination[rowIndex][columnIndex]==2){
					count=count+1;
				}
				rowIndex--;
				columnIndex--;
			}
			if(count>1){
				return false;
			}
			count=0;
			rowIndex=i;
			columnIndex=outputArray[i];
			while(rowIndex>=0 && columnIndex>=0 && 
					rowIndex<validCombination.length && columnIndex<validCombination.length){
				if(validCombination[rowIndex][columnIndex]==2){
					count=count+1;
				}
				rowIndex++;
				columnIndex--;
			}
			if(count>1){
				return false;
			}
			count=0;
			rowIndex=i;
			columnIndex=outputArray[i];
			while(rowIndex>=0 && columnIndex>=0 && 
					rowIndex<validCombination.length && columnIndex<validCombination.length){
				if(validCombination[rowIndex][columnIndex]==2){
					count=count+1;
				}
				rowIndex--;
				columnIndex++;
			}
			if(count>1){
				return false;
			}
			count=0;
			rowIndex=i;
			columnIndex=outputArray[i];
		}
		return true;
	}

}
