package Recursion3;
import java.util.Scanner;

public class SubsetOfArray {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int output[][] = solution.subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public class solution {
		
		public static int[][] returnSubset(int input[], int si){
			if(input.length==0) {
				return new int[0][0];
			}
			
			return null;
		}

		// Return a 2D array that contains all the subsets
		public static int[][] subsets(int input[]) {
			// Write your code here
			
			int arr[][]=returnSubset(input, 0);
			return arr;
		}
	}

}