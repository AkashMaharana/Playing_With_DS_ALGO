package trieAutoComplete;

public class Application {
	
	public static void main(String[] args) {
		TrieAutoComplete trie=new TrieAutoComplete();
		trie.insert("pramod");
		trie.insert("prakash");
		trie.insert("akash");
		trie.insert("pranati");
		trie.insert("richi");
		trie.allWordsWithPrefix("pra");
	}

}
