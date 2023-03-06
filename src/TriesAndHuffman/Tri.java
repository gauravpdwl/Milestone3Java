package TriesAndHuffman;

public class Tri {
	
	private TriNode root;
	
	public Tri() {
		// '\0' is used to denote null character.
		root=new TriNode('\0');
	}
	
	private void addHelper(TriNode root, String word) {
		if(word.length()==0) {
			root.isTerminal=true;
			return;
		}
		
		int childIndex=word.charAt(0)-'A';
		TriNode child=root.children[childIndex];
		if(child==null) {
			child=new TriNode(word.charAt(0));
			root.children[childIndex]=child;
			root.childCount++;
		}
		
		addHelper(child, word.substring(1));
	}
	
	public void add(String word) {
		addHelper(root, word);
	}
	
	private boolean searchHelper(TriNode root, String word) {
		if(word.length()==0 && root.isTerminal==true) {
			return true;
		}
		
		if(word.length()==0 && root.isTerminal==false) {
			return false;
		}
		
		int childIndex=word.charAt(0)-'A';
		TriNode child=root.children[childIndex];
		if(child==null) {
			return false;
		}else {
			boolean output=searchHelper(child, word.substring(1));
			return output;
		}
	}
	
	public boolean search(String word) {
		
		boolean output=searchHelper(root, word);
		return output;
	}
	
	public void removeHelper(TriNode root, String word) {
		if(word.length()==0) {
			root.isTerminal=false;
			return;
		}
		
		int childIndex=word.charAt(0) - 'A';
		TriNode child=root.children[childIndex];
		if(child==null) {
			return;
		}else {
			removeHelper(child, word.substring(1));
		}
		
		if(!child.isTerminal && child.childCount==0) {
			root.children[childIndex]=null;
			root.childCount--;
		}
	}
	
	public void remove(String word) {
		removeHelper(root, word);
	}

}
