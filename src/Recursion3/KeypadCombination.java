package Recursion3;
import java.util.Scanner;

public class KeypadCombination {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		String output[] = solution.keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}

class solution {

	// Return a string array that contains all the possible strings
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
	
	public static String[] keypad(int n){
		// Write your code here
		
		if(n==0) {
			String output[]=new String[1];
			output[0]="";
			return output;
		}
		
		int k=0;
		String[] smallOutput=keypad(n/10);
		int lastDigit=n%10;
		String lastDigitCharacters=possibleChar(lastDigit);
		String output[]=new String[smallOutput.length*lastDigitCharacters.length()];
		
		for(int i=0;i<lastDigitCharacters.length();i++) {
			for(int j=0;j<smallOutput.length;j++) {
				output[k]=smallOutput[j]+lastDigitCharacters.charAt(i);
				k++;
			}
		}
		
		return output;
	}
	
}