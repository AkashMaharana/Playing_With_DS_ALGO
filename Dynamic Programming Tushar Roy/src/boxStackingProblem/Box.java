package boxStackingProblem;

public class Box implements Comparable<Box> {

	private int height;
	private int width;
	private int length;

	public Box(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
	
	public Box(){
		
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public static Box createBox(int height, int side1, int side2) {
		Box newBox=new Box();
		newBox.height=height;
		if(side1>=side2){
			newBox.length=side1;
			newBox.width=side2;
		}
		else{
			newBox.length=side2;
			newBox.width=side1;
		}
		return newBox;
	}

	@Override
	public int compareTo(Box b1) {
		if (this.length * this.width >= b1.length * b1.width) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return "Box [height=" + height + ", length=" + length + ", width=" + width + "]";
	}

}
