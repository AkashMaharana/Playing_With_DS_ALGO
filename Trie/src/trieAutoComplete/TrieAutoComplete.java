package trieAutoComplete;

import java.util.List;
import java.util.ArrayList;

public class TrieAutoComplete {
	
	private Node root;
	
	public TrieAutoComplete(){
		this.root=new Node("");
	}
	
	public void insert(String key){
		Node tempNode=root;
		for(int i=0;i<key.length();++i){
			char c=key.charAt(i);
			int asciiIndex=c-'a';
			if(tempNode.getChild(asciiIndex)==null){
				Node newNode=new Node(String.valueOf(c));
				tempNode.setChild(asciiIndex, newNode);
				tempNode=newNode;
			}
			else{
				tempNode=tempNode.getChild(asciiIndex);
			}
		}
		tempNode.setLeaf(true);
	}
	
	public boolean search(String key){
		Node trieNode=root;
		for(int i=0;i<key.length();++i){
			char c=key.charAt(i);
			int asciiIndex=c-'a';
			if(trieNode.getChild(asciiIndex)==null){
				return false;
			}
			else{
				trieNode=trieNode.getChild(asciiIndex);
			}
		}
		return true;
	}
	
	public void allWordsWithPrefix(String prefix){
		Node trieNode=root;
		List<String> allWordsList=new ArrayList<>();
		for(int i=0;i<prefix.length();i++){
			char c=prefix.charAt(i);
			int asciiIndex=c-'a';
			trieNode=trieNode.getChild(asciiIndex);
		}
		collectAllStrings(trieNode,prefix,allWordsList);
		for(String string : allWordsList){
			System.out.println(string);
		}
	}
	
	public void collectAllStrings(Node trieNode,String prefix,List<String> allWordsList){
		if(trieNode==null){
			return;
		}
		if(trieNode.isLeaf()){
			allWordsList.add(prefix);
		}
		for(Node childNode : trieNode.getChildNodes()){
			if(childNode==null){
				continue;
			}
			String childChar=childNode.getCharacter();
			collectAllStrings(childNode, prefix+childChar,allWordsList);
		}
	}

}
