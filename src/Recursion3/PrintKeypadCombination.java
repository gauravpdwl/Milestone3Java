package Recursion3;
import java.util.Scanner;

public class PrintKeypadCombination {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		Answer.printKeypad(input);
	}
}

class Answer {
	
	public static String possibleChar(int no) {
		
		if(no==2) {
			return "abc";
		}
		
		if(no==3) {
			return "def";
		}
		
		if(no==4) {
			return "ghi";
		}
		
		if(no==5) {
			return "jkl";
		}
		
		if(no==6) {
			return "mno";
		}
		
		if(no==7) {
			return "pqrs";
		}
		
		if(no==8) {
			return "tuv";
		}
		
		if(no==9) {
			return "wxyz";
		}
		
		return "";
	}
	
	public static void print(int input, String tillnow) {
		if(input==0) {
			System.out.println(tillnow);
			return;
		}
		
		int lastno=input%10;
		String lastpart=possibleChar(lastno);
		int passno=input/10;
		for(int i=0;i<lastpart.length();i++) {
			print(passno, lastpart.charAt(i)+tillnow);
		}
	}
	
	public static void printKeypad(int input){
		// Write your code here
		print(input, "");
	}
}
