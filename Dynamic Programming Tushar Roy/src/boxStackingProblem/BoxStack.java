package boxStackingProblem;

public class BoxStack {

	public int maxHeight(Box[] input) {
		Box[] allRotations = new Box[input.length * 3];
		createAllRotations(input, allRotations);
		return 1;
	}

	private void createAllRotations(Box[] input, Box[] allRotations) {
		int index=0;
		for(int i=0;i<input.length;i++){
			allRotations[index++]=Box.createBox(input[i].getHeight(), input[i].getLength(), input[i].getWidth());
			allRotations[index++]=Box.createBox(input[i].getLength(), input[i].getHeight(), input[i].getWidth());
			allRotations[index++]=Box.createBox(input[i].getWidth(), input[i].getLength(), input[i].getHeight());
		}
	}

}
