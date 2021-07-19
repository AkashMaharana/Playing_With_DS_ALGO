package longestCommonPrefix;

public class Application {
	
	public static void main(String[] args) {
		Trie trie2=new Trie();
		trie2.insert("she");
		trie2.insert("shell");
		trie2.insert("sheshore");
		System.out.println("Longest Common Sub-String : "+trie2.longestCommonPrefix());
	}

}
