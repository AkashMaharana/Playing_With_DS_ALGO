package trieWithMap;

public class TrieWithMap {
	
	private TrieNode rootNode;
	
	public TrieWithMap(){
		rootNode=new TrieNode(true);
	}
	
	public void insert(String word){
		if(word==null || word.length()==0){
			return;
		}
		TrieNode parent=rootNode;
		for(int i=0;i<word.length();i++){
			char c=word.charAt(i);
			TrieNode childNode=parent.getChildren().get(c);
			if(childNode==null){
				childNode=new TrieNode(false);
				parent.getChildren().put(c, childNode);
			}
			parent=childNode;
		}
		parent.setLeaf(true);
	}
	
	public boolean search(String word){
		if(word==null){
			return false;
		}
		TrieNode parent=rootNode;
		for(int i=0;i<word.length();i++){
			char c=word.charAt(i);
			TrieNode tempNode=parent.getChildren().get(c);
			if(tempNode==null){
				return false;
			}
			parent=tempNode;
		}
		return parent.isLeaf();
	}
	
	public boolean startsWith(String prefix){
		if(prefix==null){
			return false;
		}
		TrieNode parent=rootNode;
		for(int i=0;i<prefix.length();i++){
			char c=prefix.charAt(i);
			TrieNode tempNode=parent.getChildren().get(c);
			if(tempNode==null){
				return false;
			}
			parent=tempNode;
		}
		return true;
	}
	
	public boolean delete(String word){
		if(word==null || word.length()==0){
			return false;
		}
		TrieNode deleteBelow=null;
		char deleteChar='\0';
		TrieNode parent=rootNode;
		for(int i=0;i<word.length();i++){
			char c=word.charAt(i);
			TrieNode child=parent.getChildren().get(c);
			if(child==null){
				return false;
			}
			if(parent.getChildren().size()>1 || parent.isLeaf()){
				deleteBelow=parent;
				deleteChar=c;
			}
			parent=child;
		}
		if(!parent.isLeaf()){
			return false;
		}
		if(parent.getChildren().isEmpty()){
			deleteBelow.getChildren().remove(deleteChar);
		}
		else{
			parent.setLeaf(false);
		}
		return true;
	}

}
