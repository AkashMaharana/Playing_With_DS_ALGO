package mazeSolver;

import java.io.File;
import java.util.Scanner;

public class FileReader {

	private String fileName;
	private int[][] maze;
	private int numberOfRows;
	private int numberOfColumns;
	private int rowStartPositon;
	private int columnStartPosition;

	public FileReader(String fileName, int numberOfRows, int numberOfColumns) {
		this.fileName = fileName;
		this.numberOfColumns = numberOfColumns;
		this.numberOfRows = numberOfRows;
		this.maze = new int[numberOfRows][numberOfColumns];
	}

	public void parseFile() {
		try {
			Scanner sc = new Scanner(new File(this.fileName));
			for (int i = 0; i < this.numberOfRows; i++) {
				for (int j = 0; j < this.numberOfColumns; j++) {
					maze[i][j] = sc.nextInt();
					if (maze[i][j] == 2) {
						this.rowStartPositon = i;
						this.columnStartPosition = j;
					}
				}
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowStartPosition() {
		return this.rowStartPositon;
	}

	public int getColumnStartPosition() {
		return this.columnStartPosition;
	}

	public int[][] getMaze() {
		return this.maze;
	}

}
