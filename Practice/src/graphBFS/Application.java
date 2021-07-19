package graphBFS;

public class Application {
	
	public static void main(String[] args) {
		BFSImpl bfs=new BFSImpl();
		Vertex v1=new Vertex(10);
		Vertex v2=new Vertex(20);
		Vertex v3=new Vertex(30);
		Vertex v4=new Vertex(40);
		Vertex v5=new Vertex(50);
		v1.addNeighbour(v2);
		v1.addNeighbour(v3);
		v2.addNeighbour(v5);
		v3.addNeighbour(v2);
		v3.addNeighbour(v4);
		v4.addNeighbour(v1);
		v5.addNeighbour(v4);
		v5.addNeighbour(v3);
		v5.addNeighbour(v2);
		bfs.bfs(v1);
	}

}
