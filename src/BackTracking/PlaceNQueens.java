package BackTracking;
import java.util.Scanner;

public class PlaceNQueens {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Solution.placeNQueens(n);	
	}
	
	public class Solution {
		
		public static void placeNQueens(int n){
				
			int path[][]=new int[n][n];
			placeQueens(path, 0, 0, n);
		}

		private static void placeQueens(int[][] path, int i, int j, int n) {
			
			if(i==n) {
				for(int k=0;k<n;k++) {
					for(int l=0;l<n;l++) {
						System.out.print(path[k][l]+ " ");
					}
				}
				System.out.println();
				return;
			}
			
			
			for(int k=j;k<n;k++) {
//				if(i==0) {
//					System.out.println("k-"+k);
//				}
				
				if(canPlace(path, i, k, n)) {
					path[i][k]=1;
					placeQueens(path, i+1, 0, n);
				}
				
				path[i][k]=0;
			}
			
		}
		
		private static boolean canPlace(int path[][], int i, int j, int n) {
			int r=i,c=j;
			//check left diagonal
			for(int k=r;k>=0;k--) {
				if(k>=0 && c>=0) {
					if(path[k][c]==1) {
						return false;
					}
				}else {
					break;
				}
				//r--;
				c--;
			}
			//check right diagonal
			r=i;
			c=j;
			for(int k=r;k>=0;k--) {
				if(k>=0 && c<=n-1) {
					if(path[k][c]==1) {
						return false;
					}
				}else {
					break;
				}
				//r--;
				c++;
			}
			//check column
			c=j;
			for(int k=r;k>=0;k--) {
				if(k>=0) {
					if(path[k][c]==1) {
						return false;
					}
				}else {
						break;
				}
			}
			
			return true;
		}
			
	}

}

/*
 * (0,0) (0,1) (0,2) (0,3)
 * (1,0) (1,1) (1,2) (1,3)
 * (2,0) (2,1) (2,2) (2,3)
 * (3,0) (3,1) (3,2) (3,3)
 */
