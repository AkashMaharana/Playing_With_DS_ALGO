package mazeSolver;

public class MazeSolver {

	private int[][] maze;
	private boolean[][] visited;
	private int rowStartposition;
	private int columnStartPosition;

	public MazeSolver(int[][] maze, int rowStartPosition, int columnStartPosition) {
		this.maze = maze;
		this.visited = new boolean[maze.length][maze[0].length];
		this.rowStartposition = rowStartPosition;
		this.columnStartPosition = columnStartPosition;
	}

	public void findWayOut() {
		try {
			dfs(rowStartposition, columnStartPosition+1);
			System.out.println("No solution found...");
		} catch (Exception e) {
			System.out.println("Route Exit");
		}
	}

	private void dfs(int i, int j) {
		System.out.println("Visiting i=" + i + ", j=" + j);
		if( this.maze[i][j] == 3 ){		
			throw new RuntimeException();
		}
		int endOfMap = this.maze.length - 1;
		if (visited[i][j]) {
			return;
		} else if (i < 0 || i >= endOfMap) {
			return;
		} else if (j < 0 || j >= endOfMap) {
			return;
		} else if (this.maze[i][j] == 1) {
			return;
		} else {
			this.visited[i][j] = true;
			dfs(i + 1, j);
			dfs(i, j + 1);
			dfs(i, j - 1);
			dfs(i - 1, j);
		}
	}

}
