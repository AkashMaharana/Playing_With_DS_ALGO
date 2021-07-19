package detectCycleInADirectedGraph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {
	
	private int noOfVertex;
	private LinkedList<Integer>[] adjacenciesList;
	private boolean[] visitedStack;
	private boolean[] recursionStack;
	
	public Graph(int noOfVertex){
		this.noOfVertex=noOfVertex;
		this.adjacenciesList=new LinkedList[this.noOfVertex];
		this.visitedStack=new boolean[this.noOfVertex];
		this.recursionStack=new boolean[this.noOfVertex];
		for(int i=0;i<this.noOfVertex;i++){
			this.adjacenciesList[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int source,int destination){
		this.adjacenciesList[source].add(destination);
	}
	
	public boolean isCyclic(){
		for(int i=0;i<this.noOfVertex;i++){
			if(isCyclicUtil(i)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isCyclicUtil(int temp){
		if(recursionStack[temp]){
			return true;
		}
		if(visitedStack[temp]){
			return false;
		}
		visitedStack[temp]=true;
		recursionStack[temp]=true;
		List<Integer> children=this.adjacenciesList[temp];
		for(Integer i : children){
			if(isCyclicUtil(i)){
				return true;
			}
		}
		recursionStack[temp]=false;
		return false;
	}
	
	public boolean isCycleDetected(int source){
		Set<Integer> whiteSet=dfs(new HashSet<Integer>(),source);
		Set<Integer> greySet=new HashSet<>();
		Set<Integer> blackSet=new HashSet<>();
		while(whiteSet.size()>0){
			Integer current=whiteSet.iterator().next();
			if(rearrangeAllSet(current, whiteSet, greySet, blackSet)){
				return true;
			}
		}
		return false;
	}
	
	private boolean rearrangeAllSet(int current,Set<Integer> whiteSet,Set<Integer> greySet,Set<Integer> blackSet){
		whiteSet.remove(current);
		greySet.add(current);
		Iterator<Integer> listIterator=this.adjacenciesList[current].listIterator();
		while(listIterator.hasNext()){
			int temp=listIterator.next();
			if(blackSet.contains(temp)){
				continue;
			}
			if(greySet.contains(temp)){
				return true;
			}
			if(rearrangeAllSet(temp,whiteSet,greySet,blackSet)){
				return true;
			}
		}
		greySet.remove(current);
		blackSet.add(current);
		return false;
	}
	
	private Set<Integer> dfs(Set<Integer> hashSet,int source){
		hashSet.add(source);
		this.visitedStack[source]=true;
		Iterator<Integer> listIterator=this.adjacenciesList[source].listIterator();
		while(listIterator.hasNext()){
			int temp=listIterator.next();
			if(this.visitedStack[temp]==false){
				dfs(hashSet,temp);
			}
		}
		return hashSet;
	}
	
	

}
