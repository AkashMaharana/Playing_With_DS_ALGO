package mazeSolver;

public class Application {
	
	public static void main(String[] args) {
		FileReader reader=new FileReader("C:\\Users\\Administrator\\OneDrive\\Desktop\\DSA_Learnbay_Codebase"
				+ "\\Graph_Udemy_Revisited\\src\\mazeSolver\\map.txt",5,5);
		reader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(reader.getMaze(),reader.getRowStartPosition(),
				reader.getColumnStartPosition());
		mazeSolver.findWayOut();
	}

}
