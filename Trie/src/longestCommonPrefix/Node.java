package longestCommonPrefix;

public class Node {

	private String character;
	private Node[] children;
	private boolean isVisited;
	private boolean isLeaf;

	public Node(String character) {
		this.character = character;
		this.children = new Node[TrieConstant.ALPHABET_SIZE];
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public void setChild(int index, Node node) {
		this.children[index] = node;
	}

	public Node getChild(int index) {
		return this.children[index];
	}

	@Override
	public String toString() {
		return this.character;
	}

}
