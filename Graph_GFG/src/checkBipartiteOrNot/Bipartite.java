package checkBipartiteOrNot;

import java.util.Queue;
import java.util.LinkedList;

public class Bipartite {
	
	public boolean isBipartite(int[][] graph){
		int numberOfVertices=graph.length;
		int[] colorArray=new int[numberOfVertices];
		for(int i=0;i<colorArray.length;i++){
			colorArray[i]=-1;
		}
		for(int i=0;i<numberOfVertices;i++){
			if(colorArray[i]==-1){
				if(!bipartiteUtil(graph,i,colorArray,numberOfVertices)){
					return false;
				}
			}
		}
		for(int i=0;i<colorArray.length;i++){
			System.out.print(colorArray[i]);
		}
		System.out.println();
		return true;
	}
	
	private boolean bipartiteUtil(int[][] graph,int startIndex,int[] colorArray,int numberOfVertices){
		colorArray[startIndex]=1;
		Queue<Integer> tempQueue=new LinkedList<>();
		tempQueue.add(startIndex);
		while(!tempQueue.isEmpty()){
			int tempValue=tempQueue.poll();
			if(graph[tempValue][tempValue]==1){
				return false;
			}
			for(int v=0;v<numberOfVertices;v++){
				if(graph[tempValue][v]==1 && colorArray[v]==-1){
					colorArray[v]=1-colorArray[tempValue];
					tempQueue.add(v);
				}
				else if(graph[tempValue][v]==1 && colorArray[tempValue]==colorArray[v]){
					return false;
				}
			}
		}
		return true;
	}

}
