package graphColoring;

public class Algorithm {
	
	private int numberOfVertex;
	private int numberOfColors;
	private int[][] graphMatrix;
	private int[] colors;
	
	public void algorithm(int[][] graphMatrix,int numberOfColors){
		this.numberOfColors=numberOfColors;
		this.graphMatrix=graphMatrix;
		this.numberOfVertex=this.graphMatrix.length;
		this.colors=new int[this.numberOfVertex];
	}
	
	public void solveColoring(){
		if(solve(0)){
			showResult();
		}
		else{
			System.out.println("Coloring can't be possible with the given number of colors");
		}
	}
	
	public boolean solve(int nodeIndex){
		if(nodeIndex==this.numberOfVertex){
			return true;
		}
		for(int colorIndex=1;colorIndex<=this.numberOfColors;colorIndex++){
			if(isValidColor(nodeIndex,colorIndex)){
				this.colors[nodeIndex]=colorIndex;
				if(solve(nodeIndex+1)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isValidColor(int nodeIndex,int colorIndex){
		for(int i=0;i<this.numberOfVertex;i++){
			if(graphMatrix[nodeIndex][i]==1 && colorIndex==this.colors[i]){
				return false;
			}
		}
		return true;
	}
	
	public void showResult(){
		for(int i=0;i<this.numberOfVertex;i++){
			System.out.println("Node"+(i+1)+" "+this.colors[i]);
		}
	}

}
