package trieSearch;

public class Application {
	
	public static void main(String[] args) {
		Trie trie=new Trie();
		trie.insert("joe");
		trie.insert("joell");
		trie.insert("akash");
		trie.insert("wati");
		trie.insert("richi");
		
		System.out.println(trie.search("cvdh"));
	}
	

}
