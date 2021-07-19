package graphColouring;

public class Algorithm {

	private int numberOfVertices;
	private int numberOfColors;
	private int[] colors;
	private int[][] graphMatrix;

	public void graphColor(int[][] graphMatrix, int numberOfColors) {
		this.numberOfVertices = graphMatrix.length;
		this.numberOfColors = numberOfColors;
		this.graphMatrix = graphMatrix;
		this.colors = new int[this.numberOfVertices];
	}

	public void solveColoringProblem() {
		if (solve(0)) {
			showResult();
		} else {
			System.out.println("No solution with given parameter....");
		}
	}

	public boolean solve(int nodeIndex) {
		if (nodeIndex == this.numberOfVertices) {
			return true;
		}
		for (int colorIndex = 1; colorIndex <= this.numberOfColors; colorIndex++) {
			if (isColorValid(nodeIndex, colorIndex)) {
				this.colors[nodeIndex] = colorIndex;
				if (solve(nodeIndex + 1)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean isColorValid(int nodeIndex, int colorIndex) {
		for(int i=0;i<this.numberOfVertices;i++){
			if(graphMatrix[nodeIndex][i]==1 && colorIndex==this.colors[i]){
				return false;
			}
		}
		
		return true;
	}

	public void showResult() {
		for(int i=0;i<this.numberOfVertices;i++){
			System.out.println("Node " + (i + 1) + " has color index: " + colors[i] + " ");
		}
		System.out.println();
	}

}
