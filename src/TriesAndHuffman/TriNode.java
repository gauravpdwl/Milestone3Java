package TriesAndHuffman;

public class TriNode {
	char data;
	boolean isTerminal;
	TriNode children[];
	int childCount;
	
	public TriNode(char data) {
		this.data=data;
		this.isTerminal=false;
		this.childCount=0;
		children=new TriNode[26];
	}
}
