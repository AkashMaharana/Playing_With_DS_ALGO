package bfs;

public class Application {

	public static void main(String[] args) {
		Vertex a=new Vertex("A");
		Vertex b=new Vertex("B");
		Vertex c=new Vertex("C");
		Vertex d=new Vertex("D");
		Vertex e=new Vertex("E");
		Vertex f=new Vertex("F");
		
		a.addNeighbour(b);
		a.addNeighbour(c);
		b.addNeighbour(d);
		c.addNeighbour(e);
		e.addNeighbour(f);
		f.addNeighbour(a);
		
		BreadthFirstSearch bfs=new BreadthFirstSearch();
		bfs.traverse(a);
	}
}
