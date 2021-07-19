package snakeAndLadderProblem;

public class Application {
	
	public static void main(String[] args) {
		
		int noOfSquares=30;
		int[] moves=new int[noOfSquares];
		for(int i=0;i<noOfSquares;i++){
			moves[i]=-1;
		}
		// Ladders 
        moves[2] = 21; 
        moves[4] = 7; 
        moves[10] = 25; 
        moves[19] = 28; 
  
        // Snakes 
        moves[26] = 0; 
        moves[20] = 8; 
        moves[16] = 3; 
        moves[18] = 6;
        
        SnakeAndLadder sal=new SnakeAndLadder();
        System.out.println("Minimum dice throws required is : "+sal.getMinimumDiceThrows(moves, noOfSquares));
	}

}
