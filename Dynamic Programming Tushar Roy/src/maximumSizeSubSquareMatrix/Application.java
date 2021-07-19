package maximumSizeSubSquareMatrix;

public class Application {
	
	public static void main(String[] args) {
		MaximumSizeSubSquareMatrix msm=new MaximumSizeSubSquareMatrix();
		int[][] inputMatrix={{0,0,1,1,1},{1,0,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
		msm.maximumSizeSubSquareMatrix(inputMatrix);
	}

}
