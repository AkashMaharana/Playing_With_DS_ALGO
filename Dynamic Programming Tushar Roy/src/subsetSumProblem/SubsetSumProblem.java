package subsetSumProblem;

import java.util.Arrays;

public class SubsetSumProblem {
	
	public void subsetSumProblem(int[] inputArray,int desiredSum){
		Arrays.sort(inputArray);
		boolean[][] booleanMatrix=new boolean[inputArray.length+1][desiredSum+1];
		booleanMatrix[0][0]=true;
		for(int i=1;i<booleanMatrix.length;i++){
			for(int j=0;j<booleanMatrix[i].length;j++){
				if(inputArray[i-1]>j){
					booleanMatrix[i][j]=booleanMatrix[i-1][j];
				}
				else{
					if(j-inputArray[i-1]>=0){
						if(booleanMatrix[i-1][j] || booleanMatrix[i-1][j-inputArray[i-1]]){
							booleanMatrix[i][j]=true;
						}
					}
					else{
						booleanMatrix[i][j]=false;
					}
				}
			}
		}
		for(int i=0;i<booleanMatrix.length;i++){
			for(int j=0;j<booleanMatrix[i].length;j++){
				System.out.print(booleanMatrix[i][j]+" ");
			}
			System.out.println();	
		}
	}

}
