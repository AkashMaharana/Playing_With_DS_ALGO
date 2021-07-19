package minimumEditDistance;

public class MinimumEditDistance {
	
	public void minimumEditDistance(String s1,String s2){
		int[][] minimumEditArray=new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<minimumEditArray[0].length;i++){
			minimumEditArray[0][i]=i;
		}
		for(int i=1;i<minimumEditArray.length;i++){
			minimumEditArray[i][0]=i;
		}
		for(int i=1;i<minimumEditArray.length;i++){
			for(int j=1;j<minimumEditArray[i].length;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					minimumEditArray[i][j]=minimumEditArray[i-1][j-1];
				}
				else{
					minimumEditArray[i][j]=Math.min(Math.min(minimumEditArray[i][j-1], 
							minimumEditArray[i-1][j-1]), minimumEditArray[i-1][j])+1;
				}
			}
		}
		//print minimumEditArray
		for(int i=0;i<minimumEditArray.length;i++){
			for(int j=0;j<minimumEditArray[i].length;j++){
				System.out.print(minimumEditArray[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Minimum edit distance : "+minimumEditArray[s1.length()][s2.length()]);
		showOperations(minimumEditArray,s1,s2);
	}
	
	private void showOperations(int[][] minimumEditArray,String s1,String s2){
		int rowIndex=s1.length();
		int columnIndex=s2.length();
		while(rowIndex>=1 && columnIndex>=1){
			if(s1.charAt(rowIndex-1)==s2.charAt(columnIndex-1)){
				rowIndex=rowIndex-1;
				columnIndex=columnIndex-1;
			}
			else{
				int minimumValue=Math.min(Math.min(minimumEditArray[rowIndex][columnIndex-1], 
						minimumEditArray[rowIndex-1][columnIndex-1]), minimumEditArray[rowIndex-1][columnIndex]);
				if(minimumEditArray[rowIndex-1][columnIndex-1]==minimumValue){
					System.out.println("Replace "+s1.charAt(rowIndex-1)+" with "+s2.charAt(columnIndex-1));
					rowIndex=rowIndex-1;
					columnIndex=columnIndex-1;
				}
				else{
					if(minimumEditArray[rowIndex][columnIndex-1]==minimumValue){
						System.out.println("Delete "+s1.charAt(rowIndex));
						columnIndex=columnIndex-1;
					}
					else{
						System.out.println("Delete "+s1.charAt(columnIndex));
						rowIndex=rowIndex-1;
					}
				}
			}
		}
	}

}
