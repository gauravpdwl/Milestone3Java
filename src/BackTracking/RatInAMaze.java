package BackTracking;
import java.util.Scanner;

public class RatInAMaze {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		System.out.println(Solution.ratInAMaze(maze));	
	}
	
	public class Solution {
		
		public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
			int n=maze.length;
			if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
				return false;
			}
			
			path[i][j]=1;
			
			if(i==n-1 && j==n-1) {
				return true;
			}
			
			//explore top, right, down, left options now
			//top
			if(solveMaze(maze, i-1,j,path)) {
				return true;
			}
			//right
			if(solveMaze(maze, i,j+1,path)) {
				return true;
			}
			//down
			if(solveMaze(maze, i+1,j,path)) {
				return true;
			}
			//left
			if(solveMaze(maze, i,j-1,path)) {
				return true;
			}
			return false;
		}
		
		public static boolean ratInAMaze(int maze[][]){
 
			int n=maze.length;
			int path[][]=new int[n][n];
			boolean output=solveMaze(maze, 0,0, path);
			return output;

		}
	}
}
