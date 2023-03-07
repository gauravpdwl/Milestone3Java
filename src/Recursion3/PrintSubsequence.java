package Recursion3;

public class PrintSubsequence {
	
	public static void printSequence(String input, String tillnow) {
		if(input.length()==0) {
			System.out.println(tillnow);
			return;
		}
		
		String small=input.substring(1);
		printSequence(small, tillnow);
		printSequence(small, tillnow+input.charAt(0));
	}
	
	public static void main(String args[]) {
		printSequence("abc", "");
	}

}
