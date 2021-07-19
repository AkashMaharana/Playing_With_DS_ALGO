package longestCommonPrefix;

import java.util.List;
import java.util.ArrayList;

public class Trie {
	
	private Node root;
	private int indexOfSingleChild=0;
	
	public Trie(){
		this.root=new Node("");
	}
	
	
	public void insert(String key){
		Node tempNode=root;
		for(int i=0;i<key.length();i++){
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
		Node tempNode=root;
		for(int i=0;i<key.length();i++){
			char c=key.charAt(i);
			int asciiIndex=c-'a';
			if(tempNode.getChild(asciiIndex)==null){
				return false;
			}
			else{
				tempNode=tempNode.getChild(asciiIndex);
			}
		}
		return true;
	}
	
	public List<String> allWordsWithPrefix(String prefix){
		Node tempNode=root;
		List<String> allString=new ArrayList<>();
		for(int i=0;i<prefix.length();i++){
			char c=prefix.charAt(i);
			int asciiIndex=c-'a';
			tempNode=tempNode.getChild(asciiIndex);
		}
		
		collectAllString(tempNode,prefix,allString);
		return allString;
	}
	
	private void collectAllString(Node node,String prefix,List<String> allString){
		if(node==null){
			return;
		}
		if(node.isLeaf()){
			allString.add(prefix);
		}
		for(Node prefixNode : node.getChildren()){
			if(prefixNode==null){
				continue;
			}
			String childCharacter=prefixNode.getCharacter();
			collectAllString(prefixNode,prefix+childCharacter,allString);
		}
	}
	
	public String longestCommonPrefix(){
		Node trieNode=root;
		String longestPrefix="";
		while(countNumberOfChildren(trieNode)==1 && !trieNode.isLeaf()){
			trieNode=trieNode.getChild(indexOfSingleChild);
			longestPrefix=longestPrefix+String.valueOf((char) (indexOfSingleChild+'a'));
		}
		return longestPrefix;
	}
	
	private int countNumberOfChildren(Node node){
		int numberOfChildren=0;
		for(int i=0;i<node.getChildren().length;++i){
			if(node.getChild(i)!=null){
				numberOfChildren=numberOfChildren+1;
				indexOfSingleChild=i;
			}
		}
		return numberOfChildren;
	}

}
