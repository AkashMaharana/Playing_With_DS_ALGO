package bfs;

public class Application {
	
	public static void main(String[] args) {
		BFS bfs=new BFS();
		Vertex v1=new Vertex(10);
		Vertex v2=new Vertex(20);
		Vertex v3=new Vertex(30);
		Vertex v4=new Vertex(40);
		Vertex v5=new Vertex(50);
		v1.addVertex(v2);
		v1.addVertex(v3);
		v2.addVertex(v5);
		v3.addVertex(v2);
		v3.addVertex(v4);
		v4.addVertex(v1);
		v5.addVertex(v4);
		v5.addVertex(v3);
		v5.addVertex(v2);
		bfs.bfs(v1);
	}

}
