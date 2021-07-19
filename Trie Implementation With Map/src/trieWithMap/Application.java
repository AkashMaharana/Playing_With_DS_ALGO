package trieWithMap;

public class Application {
	
	public static void main(String[] args) {
		TrieWithMap trieWithMap=new TrieWithMap();
		trieWithMap.insert("apple");
		trieWithMap.insert("bananna");
		System.out.println(trieWithMap.search("apple"));
		trieWithMap.delete("apple");
		System.out.println(trieWithMap.search("apple"));
	}

}
