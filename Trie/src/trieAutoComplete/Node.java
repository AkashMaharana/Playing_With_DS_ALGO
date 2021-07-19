package trieAutoComplete;

public class Node {

	private String character;
	private Node[] childNodes;
	private boolean isLeaf;
	private boolean isVisited;

	public Node(String character) {
		this.character = character;
		this.childNodes = new Node[TrieConstant.ALPHABET_SIZE];
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Node[] getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(Node[] childNodes) {
		this.childNodes = childNodes;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	@Override
	public String toString() {
		return this.character;
	}
	
	public void setChild(int index,Node node){
		this.childNodes[index]=node;
	}
	
	public Node getChild(int index){
		return this.childNodes[index];
	}

}
