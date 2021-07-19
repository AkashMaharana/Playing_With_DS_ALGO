package minimumCostPath;

public class MinimumCostPath {
	
	public void minimumCostPath(int[][] inputCostMatrix){
		int[][] outputCostmatrix=new int[inputCostMatrix.length][inputCostMatrix[0].length];
		outputCostmatrix[0][0]=inputCostMatrix[0][0];
		int sum=inputCostMatrix[0][0];
		for(int i=1;i<inputCostMatrix[0].length;i++){
			outputCostmatrix[0][i]=sum+inputCostMatrix[0][i];
			sum=outputCostmatrix[0][i];
		}
		sum=inputCostMatrix[0][0];
		for(int i=1;i<inputCostMatrix.length;i++){
			outputCostmatrix[i][0]=sum+inputCostMatrix[i][0];
			sum=outputCostmatrix[i][0];
		}
		for(int i=1;i<inputCostMatrix.length;i++){
			for(int j=1;j<inputCostMatrix[i].length;j++){
				outputCostmatrix[i][j]=inputCostMatrix[i][j]+Math.min(outputCostmatrix[i-1][j], outputCostmatrix[i][j-1]);
			}
		}
		for(int i=0;i<outputCostmatrix.length;i++){
			for(int j=0;j<outputCostmatrix[0].length;j++){
				System.out.print(outputCostmatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
