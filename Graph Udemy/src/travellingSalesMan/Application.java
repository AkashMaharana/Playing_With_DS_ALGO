package travellingSalesMan;

public class Application {
	
	public static void main(String[] args) {
		int[][] distance=new int[4][4];
		for(int i=0;i<distance.length;i++){
			for(int j=0;j<distance[i].length;j++){
				distance[i][j]=(int) (Math.random()*10);
			}
		}
		printMatrix(distance);
		TravelingSalesmanHeldKarp tsm=new TravelingSalesmanHeldKarp();
		tsm.minCost(distance);
	}
	
	private static void printMatrix(int[][] distance){
		for(int i=0;i<distance.length;i++){
			for(int j=0;j<distance[0].length;j++){
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	

}
