package maximumSizeSubSquareMatrix;

public class MaximumSizeSubSquareMatrix {
	
	public void maximumSizeSubSquareMatrix(int[][] inputMatrix){
		int[][] maxsizeMatrix=new int[inputMatrix.length+1][inputMatrix[0].length+1];
		for(int i=1;i<maxsizeMatrix.length;i++){
			for(int j=1;j<maxsizeMatrix[i].length;j++){
				if(inputMatrix[i-1][j-1]==0){
					maxsizeMatrix[i][j]=0;
				}
				else{
					maxsizeMatrix[i][j]=Math.min(Math.min(maxsizeMatrix[i][j-1], maxsizeMatrix[i-1][j]), maxsizeMatrix[i-1][j-1])+1;
				}
			}
		}
		//print maxSizeMatrix
		for(int i=0;i<maxsizeMatrix.length;i++){
			for(int j=0;j<maxsizeMatrix[0].length;j++){
				System.out.print(maxsizeMatrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Maximum size sub square matrix : "+maxsizeMatrix[maxsizeMatrix.length-1][maxsizeMatrix[0].length-1]);
	}

}
