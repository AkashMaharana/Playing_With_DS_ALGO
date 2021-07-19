package boxStackingProblem;

public class Application {

	public static void main(String[] args) {
		BoxStack bs = new BoxStack();
		Box input[] = { new Box(3, 2, 5), new Box(1, 2, 4) };
		int height = bs.maxHeight(input);
		System.out.println("Maximum height with the given boxes : " + height);
	}

}
