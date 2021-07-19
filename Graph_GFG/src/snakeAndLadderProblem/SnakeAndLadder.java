package snakeAndLadderProblem;

import java.util.Queue;
import java.util.LinkedList;

public class SnakeAndLadder {
	
	public int getMinimumDiceThrows(int[] moves,int noOfSquares){
		Queue<Node> tempQueue=new LinkedList<>();
		boolean[] isVisited=new boolean[noOfSquares];
		Node tempNode=new Node(0,0);
		isVisited[0]=true;
		tempQueue.add(tempNode);
		while(!tempQueue.isEmpty()){
			tempNode=tempQueue.poll();
			int vertex=tempNode.getVertexNumber();
			if(vertex==noOfSquares-1){
				break;
			}
			for(int i=vertex+1;i<=(vertex+6) && i<noOfSquares;i++){
				if(isVisited[i]==false){
					int nextVertex=0;
					if(moves[i]!=-1){
						nextVertex=moves[i];
					}
					else{
						nextVertex=i;
					}
					isVisited[i]=true;
					Node newNode=new Node(tempNode.getDistance()+1,nextVertex);
					tempQueue.add(newNode);
				}
			}
		}
		return tempNode.getDistance();
	}

}
