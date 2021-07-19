package checkBipartiteOrNot;

public class Application {

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };
		Bipartite b=new Bipartite();
		System.out.println(b.isBipartite(graph));
	}

}
