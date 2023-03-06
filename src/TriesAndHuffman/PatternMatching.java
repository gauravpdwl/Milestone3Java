package TriesAndHuffman;

import java.util.ArrayList;

// TrieNode class is already present in another class under same package
// If you don't have then remove comment from TrieNode class.

//class TrieNode{
//
//	char data;
//	boolean isTerminating;
//	TrieNode children[];
//	int childCount;
//
//	public TrieNode(char data) {
//		this.data = data;
//		isTerminating = false;
//		children = new TrieNode[26];
//		childCount = 0;
//	}
//}


public class PatternMatching {

	private TrieNode root;
	public int count;
	public PatternMatching() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		//System.out.println(word.charAt(0)+" "+child);
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}

	private void addHelper(TrieNode root, String word){

		if(word.length()==0){
			root.isTerminating=true;
			return;
		}

		int childIndex=word.charAt(0)-'a';
		TrieNode child=root.children[childIndex];

		if(child==null){
			child=new TrieNode(word.charAt(0));
			root.children[childIndex]=child;
		}
		//System.out.println(child.data);

		addHelper(child, word.substring(1));
	}
	public void add(String word){
		addHelper(root, word);
	}

	public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
		for(int i=0;i<vect.size();i++){
			String word=vect.get(i);
			for(int j=0;j<word.length();j++){
				//System.out.println(word.substring(j));
				add(word.substring(j));
			}
		}

		boolean output=search(pattern);
		return output;

	}

}