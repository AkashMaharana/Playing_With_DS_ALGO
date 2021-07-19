package trieSearch;

public class Node {

	private String character;
	private Node[] children;
	private boolean leaf;
	private boolean isVisited;

	public Node(String character) {
		this.character = character;
		children = new Node[TrieConstants.ALPHABET_SIZE];
	}

	public void setChild(int index, Node node) {
		this.children[index] = node;
	}

	@Override
	public String toString() {
		return this.character;
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

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public Node getChild(int index){
		return this.children[index];
	}

}
