package graphColoring;

public class Application {
	
	public static void main(String[] args) {
		Algorithm graphColoring = new Algorithm();   
	    
        int[][] graphMatrix = new int[][]{
        		{0,1,0,1,0},
        		{1,0,1,1,0},
        		{0,1,0,1,0},
        		{1,1,1,0,1},
        		{0,0,0,1,0}
        };
     
        int numOfColors = 4;
 
        graphColoring.algorithm(graphMatrix,numOfColors);
        graphColoring.solveColoring();
	}

}
