package trieWithMap;

import java.util.Map;
import java.util.HashMap;

public class TrieNode {

	private boolean isLeaf;
	Map<Character, TrieNode> children;

	public TrieNode(boolean isLeaf) {
		this.isLeaf = isLeaf;
		this.children = new HashMap<>();
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

}
