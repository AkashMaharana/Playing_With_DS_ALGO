package integerPartitionCoinChangeProblem;

public class IntegerPartitionCoinChange {
	
	public void integerPartitionNumber(int inputNumber){
		int[][] partitionMatrix=new int[inputNumber+1][inputNumber+1];
		partitionMatrix[0][0]=1;
		for(int i=1;i<partitionMatrix[0].length;i++){
			partitionMatrix[0][i]=0;
		}
		for(int i=1;i<partitionMatrix.length;i++){
			for(int j=0;j<partitionMatrix[i].length;j++){
				if(i>j){
					partitionMatrix[i][j]=partitionMatrix[i-1][j];
				}
				else{
					partitionMatrix[i][j]=partitionMatrix[i-1][j]+partitionMatrix[i][j-i];
				}
			}
		}
		
		for(int i=0;i<partitionMatrix.length;i++){
			for(int j=0;j<partitionMatrix[i].length;j++){
				System.out.print(partitionMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
