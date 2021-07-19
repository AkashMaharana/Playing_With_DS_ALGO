package byteByByte;

public class _3_MatrixProduct {
	
	/*Maximum Matrix Product*/
	
	public static void main(String[] args) {
		int[][] inputMatrix= {{1,2,3},{4,5,6},{7,8,9}};
		maximumProductPath(inputMatrix);
	}
	
	private static void maximumProductPath(int[][] inputMatrix) {
		int[][] outputMatrix=new int[inputMatrix.length+1][inputMatrix[0].length+1];
		for(int i=0;i<outputMatrix.length;i++) {
			outputMatrix[0][i]=1;
		}
		for(int i=0;i<outputMatrix[0].length;i++) {
			outputMatrix[i][0]=1;
		}
		for(int i=1;i<outputMatrix.length;i++) {
			for(int j=1;j<outputMatrix[i].length;j++) {
				outputMatrix[i][j]=Math.max(inputMatrix[i-1][j-1]*outputMatrix[i-1][j], inputMatrix[i-1][j-1]*outputMatrix[i][j-1]);
			}
		}
		System.out.println("Maximum Product : "+outputMatrix[outputMatrix.length-1][outputMatrix[0].length-1]);
		int start=outputMatrix.length-1;
		int end=outputMatrix[0].length-1;
		System.out.print("maimum Path : ");
		while(start!=0 && end!=0) {
			System.out.print(inputMatrix[start-1][end-1]+" ");
			int number=outputMatrix[start][end]/inputMatrix[start-1][end-1];
			if(number==outputMatrix[start-1][end]) {
				start=start-1;
			}
			else {
				end=end-1;
			}
		}
	}

}
