package TriesAndHuffman;

import java.util.ArrayList;

// ............if you have below TrieNode class in any other file in same package then
//keep comment as it is otherwise remove it...........................................

//class TrieNode{
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

public class AutoCompleteTrie {
	private TrieNode root;
	public int count;
	public AutoCompleteTrie() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
	
	public void printRest(TrieNode root, String word){
		boolean isEmpty=true;
		for(int i=0;i<26;i++){
			TrieNode node= root.children[i];
			if(node!=null){
				isEmpty=false;
			}
		}

		if(isEmpty==true){
			return;
		}
		String tempword="";
		for(int i=0;i<26;i++){
			TrieNode node= root.children[i];
			if(node!=null){
				tempword=word+node.data;
				if(node.isTerminating==true){
					System.out.println(tempword);
				}
				printRest(node, tempword);
				tempword="";
			}
		}
	}
	public void autoCompleteHelper(TrieNode root, String word, String oword){
		if(word==null){
			return;
		}
		if(word.length()==0){
			if(root.isTerminating==true){
				System.out.println(oword);
			}
			//System.out.println(root.data);
			printRest(root, oword);
			return;
		}
		int childIndex=word.charAt(0)-'a';
		TrieNode child=root.children[childIndex];

		if(child==null){
			return;
		}else{
			//System.out.println(child.data+" "+word.substring(1)+" oword");
			autoCompleteHelper(child, word.substring(1), oword);
		}
	}
	public void autoComplete(ArrayList<String> input, String word) {

        // Write your code here
		//Trie tri=new Trie();
		for(int i=0;i<input.size();i++){
			//System.out.println(input.get(i));
			add(input.get(i));
		}

		autoCompleteHelper(root, word, word);

    }

}