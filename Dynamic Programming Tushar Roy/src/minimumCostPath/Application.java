package minimumCostPath;

public class Application {
	
	public static void main(String[] args) {
		MinimumCostPath mmc=new MinimumCostPath();
		int[][] inputCostMatrix={{1,3,5,8},{4,2,1,7},{4,3,2,3}};
		mmc.minimumCostPath(inputCostMatrix);
	}

}
