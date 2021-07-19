package totalNoOfWaysToMakeADenomination;

public class totalNumberOfWaysToMakeADenomination {
	
	public void minimumNumberOfWays(int[] denomination,int total){
		int[][] denominationMatrix=new int[denomination.length+1][total+1];
		for(int i=0;i<denominationMatrix.length;i++){
			denominationMatrix[i][0]=1;
		}
		for(int i=1;i<denominationMatrix.length;i++){
			for(int j=1;j<denominationMatrix[i].length;j++){
				if(denomination[i-1]>j){
					denominationMatrix[i][j]=denominationMatrix[i-1][j];
				}
				else{
					denominationMatrix[i][j]=denominationMatrix[i-1][j]+denominationMatrix[i][j-denomination[i-1]];
				}
			}
		}
		System.out.println(denominationMatrix[denomination.length][total]);
		System.out.println("Denomination Matrix");
		for(int i=0;i<denominationMatrix.length;i++){
			for(int j=0;j<denominationMatrix[0].length;j++){
				System.out.print(denominationMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
