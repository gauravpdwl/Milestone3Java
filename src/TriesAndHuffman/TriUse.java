package TriesAndHuffman;

public class TriUse {
	public static void main(String args[]) {
		Tri t=new Tri();
		t.add("HELLOJI");
		t.add("HELLO");
		t.remove("HELLOJI");
		String word="HELLO";
		System.out.println("Word present in Tri? "+word+" - "+t.search(word));
	}
}
