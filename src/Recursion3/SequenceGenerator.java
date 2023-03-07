package Recursion3;

import java.util.ArrayList;

class SubSequenceGenerator {
	
	ArrayList<String> arr=new ArrayList<>();
	
	public void subSequence(String s) {
		if(s.length()==0) {
			arr.add(s);
			return;
		}
		
		subSequence(s.substring(1));
		String a[]=new String[arr.size()];
		int counter=0;
		for(int i=0;i<arr.size();i++) {
			String val=arr.get(i);
			a[counter]=s.charAt(0)+val;
			counter++;
		}
		
		for(int i=0;i<a.length;i++) {
			arr.add(a[i]);
		}
	}
	
	public void displaySubSequence() {
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
}

public class SequenceGenerator{
	 public static void main(String args[]) {
			SubSequenceGenerator s=new SubSequenceGenerator();
			s.subSequence("abc");
			s.displaySubSequence();
	}
}

